package com.hfrsoussama.mymvpapp.features.auth.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.hfrsoussama.mymvpapp.R;
import com.hfrsoussama.mymvpapp.databinding.ActivityLoginBinding;
import com.hfrsoussama.mymvpapp.features.auth.presenter.LoginPresenter;
import com.hfrsoussama.mymvpapp.features.auth.presenter.LoginPresenterImpl;
import com.hfrsoussama.mymvpapp.features.myjokes.view.MyJokesActivity;

public class LoginActivity extends Activity implements LoginView {

    private ActivityLoginBinding loginBinding;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginBinding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onClickLogin(View v) {
        loginPresenter.validateCredantials(
                loginBinding.tiUsernameLoginActivity.getText().toString(),
                loginBinding.tiPasswordLoginActivity.getText().toString()
        );
    }

    @Override
    public void showProgress() {
        loginBinding.pbVerificationLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loginBinding.pbVerificationLogin.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError() {
        loginBinding.tvErrorLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        loginBinding.tvErrorLogin.setVisibility(View.INVISIBLE);
    }

    @Override
    public void navigateToMyJokes() {
        startActivity(new Intent(LoginActivity.this, MyJokesActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }
}
