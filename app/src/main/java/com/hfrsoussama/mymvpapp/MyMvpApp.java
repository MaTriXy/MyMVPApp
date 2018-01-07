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

    private static NetworkingComponent sNetworkingComponent;

    private static DaoSession mDaoSession;


    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationModule applicationModule = new ApplicationModule(this);

        sNetworkingComponent = DaggerNetworkingComponent.builder()
                .applicationModule(applicationModule)
                .networkingModule(new NetworkingModule(BuildConfig.JOKES_API_BASE_URL))
                .build();

        mDaoSession = new DaoMaster(
                new DbOpenHelper(this, "greendao_demo.db").getWritableDb()
        ).newSession();


    }

    public static NetworkingComponent getNetworkingComponent() {
        return sNetworkingComponent;
    }

    public static DaoSession getDaoSession() {
        return mDaoSession;
    }
}
