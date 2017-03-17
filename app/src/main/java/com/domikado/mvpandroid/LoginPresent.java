package com.domikado.mvpandroid;
// Created by irwancannady (irwancannady@gmail.com) on 1/13/17.

import android.text.TextUtils;

public class LoginPresent implements LoginInterface {


    private LoginView loginView;

    public LoginPresent(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            loginView.showMessageError();
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                loginView.loginSuccess();
            } else {
                loginView.loginError();
            }
        }
    }
}
