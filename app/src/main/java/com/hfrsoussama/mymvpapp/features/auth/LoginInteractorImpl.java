package com.hfrsoussama.mymvpapp.features.auth;

import android.text.TextUtils;

import com.hfrsoussama.mymvpapp.MyMvpApp;
import com.hfrsoussama.mymvpapp.repository.network.endpoints.WebServiceEndPoints;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Oussama on 16/12/2017.
 */

public class LoginInteractorImpl implements LoginInteractor{

    @Inject
    WebServiceEndPoints mWebServiceEndPoints;

    private CompositeDisposable mCompositeDisposable;

    public LoginInteractorImpl() {
        MyMvpApp.getNetworkingComponent().inject(this);
        mCompositeDisposable = new CompositeDisposable();
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
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }


}
