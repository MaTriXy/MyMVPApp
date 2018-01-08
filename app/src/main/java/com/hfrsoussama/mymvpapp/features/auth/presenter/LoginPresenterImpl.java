package com.hfrsoussama.mymvpapp.features.auth.presenter;

import com.hfrsoussama.mymvpapp.features.auth.interactor.LoginInteractor;
import com.hfrsoussama.mymvpapp.features.auth.interactor.LoginInteractorImpl;
import com.hfrsoussama.mymvpapp.features.auth.view.LoginView;

/**
 * Created by Oussama on 16/12/2017.
 */

public class LoginPresenterImpl implements LoginPresenter,
        LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredantials(String username, String password) {
        if (loginView != null) {
            loginView.hideError();
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);

    }

    @Override
    public void onDestroy() {
        loginInteractor.clearDisposables();
        loginView = null;
    }

    @Override
    public void onError() {
        if (loginView == null)
             return;

        loginView.hideProgress();
        loginView.showError();
    }

    @Override
    public void onSuccess() {
        if (loginView == null)
            return;

        loginView.hideProgress();
        loginView.navigateToMyJokes();
    }
}
