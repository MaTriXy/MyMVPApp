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
        MyJokesInteractor.OnFetchJokesListener, MyJokesInteractor.OnPersistListener{

    private MyJokesView mMyJokesView;
    private MyJokesInteractor mMyJokesInteractor;


    public MyJokesPresenterImpl(MyJokesView myJokesView) {
        mMyJokesView = myJokesView;
        mMyJokesInteractor = new MyJokesInteractorImpl();
    }


    @Override
    public void fetchJokes() {
        mMyJokesInteractor.fetchJokes(this);
    }

    @Override
    public void onDestroy() {
        mMyJokesView = null;
    }

    @Override
    public void onSuccessFetchingJokes(List<Joke> jokeList) {
        if (mMyJokesView == null)
            return;

        mMyJokesView.hideLoading();
        mMyJokesView.showJokes(jokeList);

        mMyJokesInteractor.persisteJokes(jokeList, this);

    }

    @Override
    public void onErrorFetchingJokes(Throwable Error) {
        if (mMyJokesView == null)
            return;
        mMyJokesView.hideLoading();
        mMyJokesView.showError();

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
