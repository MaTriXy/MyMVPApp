package com.hfrsoussama.mymvpapp.features.auth;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hfrsoussama.mymvpapp.R;
import com.hfrsoussama.mymvpapp.databinding.ActivityLoginBinding;
import com.hfrsoussama.mymvpapp.features.myjokes.view.MyJokesActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ActivityLoginBinding mLoginBinding;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void onClickLogin(View v) {
        mLoginPresenter.validateCredantials(
                mLoginBinding.tiUsernameLoginActivity.getText().toString(),
                mLoginBinding.tiPasswordLoginActivity.getText().toString()
        );
    }

    @Override
    public void showProgress() {
        mLoginBinding.pbVerificationLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoginBinding.pbVerificationLogin.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError() {
        mLoginBinding.tvErrorLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        mLoginBinding.tvErrorLogin.setVisibility(View.INVISIBLE);
    }

    @Override
    public void navigateToMyJokes() {
        startActivity(new Intent(LoginActivity.this, MyJokesActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.onDestroy();
        super.onDestroy();
    }
}
