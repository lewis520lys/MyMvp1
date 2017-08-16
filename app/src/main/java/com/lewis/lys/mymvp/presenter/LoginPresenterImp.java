package com.lewis.lys.mymvp.presenter;



import com.lewis.lys.mymvp.model.ImplLoginModel;
import com.lewis.lys.mymvp.model.LoginModel;
import com.lewis.lys.mymvp.model.OnLoginFinishedListener;
import com.lewis.lys.mymvp.view.LoginView;

/**
 * Created by Administrator on 2017/8/15 0015.
 */

public class LoginPresenterImp implements LoginPresenter, OnLoginFinishedListener {
    LoginModel model;
    LoginView view;
    @Override
    public void validateCredentials(String username, String password) {
    if (view!=null){
        view.showProgress();
    }
    model.login(username,password,this);
    }

    @Override
    public void onDestroy() {
       view=null;
    }

    public LoginPresenterImp(LoginView view) {
        this.view = view;
        model=new ImplLoginModel();
    }

    @Override
    public void onUsernameError() {
        if (view!=null){
            view.hideProgress();
            view.setUsernameError();
        }

    }

    @Override
    public void onPasswordError() {
        if (view!=null){
            view.setPasswordError();
            view.hideProgress();
        }

    }

    @Override
    public void onSuccess() {
        if (view!=null){
            view.navigateToHome();
            view.hideProgress();
        }


    }
}
