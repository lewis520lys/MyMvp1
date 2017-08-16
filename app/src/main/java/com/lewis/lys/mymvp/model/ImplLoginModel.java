package com.lewis.lys.mymvp.model;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Administrator on 2017/8/15 0015.
 */

public class ImplLoginModel implements LoginModel {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean erroe=false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    erroe=true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    erroe=true;
                }
                if (!erroe){
                    listener.onSuccess();
                }
            }
        },2000);
    }
}
