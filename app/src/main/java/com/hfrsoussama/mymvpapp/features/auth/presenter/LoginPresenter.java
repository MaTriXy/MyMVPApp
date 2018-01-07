package com.hfrsoussama.mymvpapp.features.auth.presenter;

/**
 * Created by Oussama on 16/12/2017.
 */

public interface LoginPresenter {

    void validateCredantials(String username, String password);

    void onDestroy();
}
