package com.hfrsoussama.mymvpapp.features.auth;

/**
 * Created by Oussama on 16/12/2017.
 */

public class LoginPresenterImpl implements LoginPresenter,
        LoginInteractor.OnLoginFinishedListener {

    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        mLoginView = loginView;
        mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredantials(String username, String password) {
        if (mLoginView != null) {
            mLoginView.hideError();
            mLoginView.showProgress();
        }

        mLoginInteractor.login(username, password, this);

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
        mLoginView.navigateToMyJokes();
    }
}
