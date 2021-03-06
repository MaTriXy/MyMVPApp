package com.hfrsoussama.mymvpapp.features.auth.view;

/**
 * Created by Oussama on 16/12/2017.
 */

import android.view.View;

/**
 * This interface describes different behaviors of the Login View UI
 *
 * */

public interface LoginView {

    void onClickLogin(View v);

    void showProgress();

    void hideProgress();

    void showError();

    void hideError();

    void navigateToMyJokes();

}
