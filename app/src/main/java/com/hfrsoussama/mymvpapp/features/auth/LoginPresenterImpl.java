package com.hfrsoussama.mymvpapp.features.auth;

import android.util.Log;

import com.hfrsoussama.mymvpapp.repository.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 16/12/2017.
 */

public class LoginPresenterImpl implements LoginPresenter,
        LoginInteractor.OnLoginFinishedListener, LoginInteractor.OnJokeListFetchListener {

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView, LoginInteractor loginInteractor) {
        mLoginView = loginView;
        mLoginInteractor = loginInteractor;
    }

    @Override
    public void validateCredantials(String username, String password) {
        if (mLoginView != null) {
            mLoginView.hideError();
            mLoginView.showProgress();
        }

        // mLoginInteractor.login(username, password, this);
        mLoginInteractor.fetchJokes(this);

    }

    @Override
    public void onDestroy() {
        mLoginInteractor.clearDisposables();
        mLoginView = null;
    }

    @Override
    public void onError() {
        if (mLoginView == null)
            return;

        mLoginView.hideProgress();
        mLoginView.showError();
    }

    @Override
    public void onSuccess() {
        if (mLoginView == null)
            return;

        mLoginView.hideProgress();
        mLoginView.navigateToMain();
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onSuccess(List<Joke> jokeList) {
        Log.i("MVPAPP", jokeList.toString());
    }
}
