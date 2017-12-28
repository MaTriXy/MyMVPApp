package com.hfrsoussama.mymvpapp.features.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hfrsoussama.mymvpapp.R;
import com.hfrsoussama.mymvpapp.features.auth.LoginActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SplashActivity extends AppCompatActivity implements SplashView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 3 seconds delay
        Completable.timer(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::navigateToLogin);

    }

    @Override
    public void navigateToLogin() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
