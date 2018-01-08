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

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return application;
    }

    @Provides
    Context providesContext(){
        return application;
    }

    @Provides
    Resources providesResources(){
        return application.getResources();
    }
}
