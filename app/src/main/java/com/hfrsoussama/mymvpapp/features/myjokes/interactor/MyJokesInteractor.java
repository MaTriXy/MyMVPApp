package com.hfrsoussama.mymvpapp.features.myjokes.interactor;

import com.hfrsoussama.mymvpapp.data.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 02/01/2018.
 */

public interface MyJokesInteractor {

    interface OnFetchJokesListener {

        void onSuccessFetchingJokes(List<Joke> jokeList);

        void onErrorFetchingJokes(Throwable Error);

    }

    interface OnPersistListener {

        void onSuccessPersisting();

        void onErrorPersisting(Throwable Error);

    }


    void fetchJokes(OnFetchJokesListener listener);

    void persisteJokes(List<Joke> jokeList, OnPersistListener listener);

    void clearDisposables();

}
