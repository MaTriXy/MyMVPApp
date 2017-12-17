package com.hfrsoussama.mymvpapp.auth;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by Oussama on 16/12/2017.
 */

public class LoginInteractorImpl implements LoginInteractor{

    @Override
    public void login(String username, String password, OnLoginFinishedListener listener) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            listener.onError();
            return;
        }

        Completable.timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess);
    }
}
