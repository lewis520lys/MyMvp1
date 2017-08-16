package com.lewis.lys.mymvp.model;

public interface LoginModel {
    void login(String username, String password, OnLoginFinishedListener listener);
}