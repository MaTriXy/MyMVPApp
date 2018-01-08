package com.hfrsoussama.mymvpapp.features.auth.interactor;

import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Oussama on 16/12/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private CompositeDisposable compositeDisposable;

    public LoginInteractorImpl() {
        compositeDisposable = new CompositeDisposable();
    }

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


    @Override
    public void clearDisposables() {
        if (compositeDisposable != null)
            compositeDisposable.clear();
    }


}
