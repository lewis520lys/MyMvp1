package com.lewis.lys.mymvp.presenter;

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}