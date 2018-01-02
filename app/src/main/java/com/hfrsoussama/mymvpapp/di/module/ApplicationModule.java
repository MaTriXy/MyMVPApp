package com.hfrsoussama.mymvpapp.di.module;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Oussama on 20/12/2017.
 */

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return mApplication;
    }

    @Provides
    Context providesContext(){
        return mApplication;
    }

    @Provides
    Resources providesResources(){
        return mApplication.getResources();
    }
}
