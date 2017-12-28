package com.hfrsoussama.mymvpapp;

import android.app.Application;

import com.hfrsoussama.mymvpapp.di.component.DaggerNetworkingComponent;
import com.hfrsoussama.mymvpapp.di.component.NetworkingComponent;
import com.hfrsoussama.mymvpapp.di.module.ApplicationModule;
import com.hfrsoussama.mymvpapp.di.module.NetworkingModule;


/**
 * Created by Oussama on 16/12/2017.
 */

public class MyMvpApp extends Application {

    private static NetworkingComponent mNetworkingComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetworkingComponent = DaggerNetworkingComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkingModule(new NetworkingModule(BuildConfig.JOKES_API_BASE_URL))
                .build();

    }

    public static NetworkingComponent getNetworkingComponent() {
        return mNetworkingComponent;
    }
}
