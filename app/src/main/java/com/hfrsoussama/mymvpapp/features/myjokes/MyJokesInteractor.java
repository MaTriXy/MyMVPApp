package com.hfrsoussama.mymvpapp.features.myjokes;

import com.hfrsoussama.mymvpapp.repository.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 28/12/2017.
 */

public interface MyJokesInteractor {

    interface onJokesListFetchListener{

        void onSuccess(List<Joke> jokeList);

        void onError(Throwable throwable);
    }

    void fetchJokes(onJokesListFetchListener listener);

    void clearDisposable();
}
