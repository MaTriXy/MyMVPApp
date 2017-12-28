package com.hfrsoussama.mymvpapp.features.auth;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.hfrsoussama.mymvpapp.MyMvpApp;
import com.hfrsoussama.mymvpapp.di.component.DaggerNetworkingComponent;
import com.hfrsoussama.mymvpapp.di.component.NetworkingComponent;
import com.hfrsoussama.mymvpapp.di.module.NetworkingModule;
import com.hfrsoussama.mymvpapp.repository.network.endpoints.WebServiceEndPoints;
import com.hfrsoussama.mymvpapp.repository.network.helper.ApiHelperImpl;
import com.hfrsoussama.mymvpapp.repository.network.model.ChuckNorrisResponse;
import com.hfrsoussama.mymvpapp.repository.network.model.Joke;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

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
    public void fetchJokes(OnJokeListFetchListener listener) {
        mCompositeDisposable.add(mWebServiceEndPoints.getAllChuckNorrisJokes()
                .subscribeOn(Schedulers.computation())
                .map(ChuckNorrisResponse::getJokeList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        listener::onSuccess,
                        listener::onError
                ));
    }

    @Override
    public void clearDisposables() {
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }


}
