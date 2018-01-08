package com.hfrsoussama.mymvpapp;

import android.app.Application;

import com.hfrsoussama.mymvpapp.data.db.DbOpenHelper;
import com.hfrsoussama.mymvpapp.data.db.model.DaoMaster;
import com.hfrsoussama.mymvpapp.data.db.model.DaoSession;
import com.hfrsoussama.mymvpapp.di.component.DaggerNetworkingComponent;
import com.hfrsoussama.mymvpapp.di.component.NetworkingComponent;
import com.hfrsoussama.mymvpapp.di.module.ApplicationModule;
import com.hfrsoussama.mymvpapp.di.module.NetworkingModule;


/**
 * Created by Oussama on 16/12/2017.
 */

public class MyMvpApp extends Application {

    private static NetworkingComponent networkingComponent;

    private static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationModule applicationModule = new ApplicationModule(this);

        networkingComponent = DaggerNetworkingComponent.builder()
                .applicationModule(applicationModule)
                .networkingModule(new NetworkingModule(BuildConfig.JOKES_API_BASE_URL))
                .build();

        daoSession = new DaoMaster(
                new DbOpenHelper(this, "jokes.db").getWritableDb()
        ).newSession();


    }

    public static NetworkingComponent getNetworkingComponent() {
        return networkingComponent;
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
