package com.hfrsoussama.mymvpapp.di.component;

import com.hfrsoussama.mymvpapp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Oussama on 28/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    // inject somewhere
}
