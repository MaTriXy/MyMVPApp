package com.hfrsoussama.mymvpapp.di.component;

import com.hfrsoussama.mymvpapp.di.module.ApplicationModule;
import com.hfrsoussama.mymvpapp.di.module.NetworkingModule;
import com.hfrsoussama.mymvpapp.features.auth.LoginInteractorImpl;
import com.hfrsoussama.mymvpapp.features.myjokes.interactor.MyJokesInteractorImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Oussama on 20/12/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkingModule.class})
public interface NetworkingComponent {

    void inject(MyJokesInteractorImpl myJokesInteractor);

}
