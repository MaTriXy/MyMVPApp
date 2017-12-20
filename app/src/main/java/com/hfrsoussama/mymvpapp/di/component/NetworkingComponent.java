package com.hfrsoussama.mymvpapp.di.component;

import com.hfrsoussama.mymvpapp.auth.LoginActivity;
import com.hfrsoussama.mymvpapp.auth.LoginInteractor;
import com.hfrsoussama.mymvpapp.di.module.ApplicationModule;
import com.hfrsoussama.mymvpapp.di.module.NetworkingModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Oussama on 20/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkingModule.class})
public interface NetworkingComponent {

    void inject(LoginInteractor loginInteractor);
}
