package com.lewis.lys.mymvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.lewis.lys.mymvp.presenter.LoginPresenterImp;
import com.lewis.lys.mymvp.view.LoginView;


/**
 * Created by Administrator on 2017/8/15 0015.
 */

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {
    private EditText name;
    private EditText pwd;
    private ProgressBar pb;
    private Button bt;
    private LoginPresenterImp loginPresenterImp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loginPresenterImp = new LoginPresenterImp(this);
    }

    @Override
    public void showProgress() {
       pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUsernameError() {
       Toast.makeText(this,"账号错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this,"成功",Toast.LENGTH_SHORT).show();
    }



    private void initView() {
        name = (EditText) findViewById(R.id.name);
        pwd = (EditText) findViewById(R.id.pwd);
        pb = (ProgressBar) findViewById(R.id.pb);
        bt = (Button) findViewById(R.id.bt);

        bt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
             loginPresenterImp.validateCredentials(name.getText().toString(),pwd.getText().toString());
                break;
        }
    }


}
