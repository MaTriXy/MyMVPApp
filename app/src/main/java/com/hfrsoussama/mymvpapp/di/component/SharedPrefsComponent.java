package com.hfrsoussama.mymvpapp.di.component;

import com.hfrsoussama.mymvpapp.di.module.ApplicationModule;
import com.hfrsoussama.mymvpapp.di.module.SharedPrefsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Oussama on 02/01/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, SharedPrefsModule.class})
public interface SharedPrefsComponent {
}
