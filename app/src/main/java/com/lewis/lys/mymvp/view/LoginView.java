package com.lewis.lys.mymvp.view;

/**
 * Created by Administrator on 2017/8/15 0015.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
