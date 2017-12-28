package com.hfrsoussama.mymvpapp.features.auth;

import com.hfrsoussama.mymvpapp.repository.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 16/12/2017.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {

        void onError();

        void onSuccess();

    }

    interface OnJokeListFetchListener {

        void onError(Throwable throwable);

        void onSuccess(List<Joke> jokeList);

    }

    void login(String username, String password, OnLoginFinishedListener listener);

    void fetchJokes (OnJokeListFetchListener listener);

    void clearDisposables();
}
