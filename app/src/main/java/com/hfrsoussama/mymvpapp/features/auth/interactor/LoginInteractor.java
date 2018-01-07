package com.hfrsoussama.mymvpapp.features.auth.interactor;

/**
 * Created by Oussama on 16/12/2017.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {

        void onError();

        void onSuccess();

    }

    void login(String username, String password, OnLoginFinishedListener onLoginFinishedListener);

    void clearDisposables();
}
