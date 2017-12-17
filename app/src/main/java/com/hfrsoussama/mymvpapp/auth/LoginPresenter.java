package com.hfrsoussama.mymvpapp.auth;

/**
 * Created by Oussama on 16/12/2017.
 */

public interface LoginPresenter {

    void validateCredantials(String username, String password);

    void onDestroy();
}
