package com.hfrsoussama.mymvpapp.features.myjokes;

import com.hfrsoussama.mymvpapp.repository.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 28/12/2017.
 */

public class MyJokesPrensenterImpl implements MyJokesPresenter, MyJokesInteractor.onJokesListFetchListener {

    private MyJokesView mMyJokesView;
    private MyJokesInteractor mMyJokesInteractor;

    public MyJokesPrensenterImpl(MyJokesView myJokesView, MyJokesInteractor myJokesInteractor) {
        this.mMyJokesView = myJokesView;
        this.mMyJokesInteractor = myJokesInteractor;
    }

    @Override
    public void fetchJokesList() {
        mMyJokesInteractor.fetchJokes(this);
    }

    @Override
    public void onDestroy() {
        mMyJokesView = null;
    }

    @Override
    public void onSuccess(List<Joke> jokeList) {
        mMyJokesView.showMyJokes(jokeList);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}
