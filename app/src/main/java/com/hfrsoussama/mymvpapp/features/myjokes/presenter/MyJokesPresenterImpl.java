package com.hfrsoussama.mymvpapp.features.myjokes.presenter;

import android.util.Log;

import com.hfrsoussama.mymvpapp.features.myjokes.interactor.MyJokesInteractor;
import com.hfrsoussama.mymvpapp.features.myjokes.interactor.MyJokesInteractorImpl;
import com.hfrsoussama.mymvpapp.features.myjokes.view.MyJokesView;
import com.hfrsoussama.mymvpapp.data.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 02/01/2018.
 */

public class MyJokesPresenterImpl implements MyJokesPresenter,
        MyJokesInteractor.OnFetchJokesListener,
        MyJokesInteractor.OnPersistListener{

    private MyJokesView myJokesView;
    private MyJokesInteractor myJokesInteractor;


    public MyJokesPresenterImpl(MyJokesView myJokesView) {
        this.myJokesView = myJokesView;
        myJokesInteractor = new MyJokesInteractorImpl();
    }


    @Override
    public void fetchJokes() {
        myJokesInteractor.fetchJokes(this);
    }

    @Override
    public void onDestroy() {
        myJokesView = null;
    }

    @Override
    public void onSuccessFetchingJokes(List<Joke> jokeList) {
        if (myJokesView == null)
            return;

        myJokesView.hideLoading();
        myJokesView.showJokes(jokeList);

        myJokesInteractor.persisteJokes(jokeList, this);

    }

    @Override
    public void onErrorFetchingJokes(Throwable Error) {
        if (myJokesView == null)
            return;
        myJokesView.hideLoading();
        myJokesView.showError();

    }

    @Override
    public void onSuccessPersisting() {
        Log.e("TAG", "YOHOOO");
    }

    @Override
    public void onErrorPersisting(Throwable Error) {
        Log.e("TAG", "EROROOOOOr");

    }
}
