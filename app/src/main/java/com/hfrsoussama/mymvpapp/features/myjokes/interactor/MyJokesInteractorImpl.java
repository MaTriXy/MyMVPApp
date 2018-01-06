package com.hfrsoussama.mymvpapp.features.myjokes.interactor;

import com.hfrsoussama.mymvpapp.MyMvpApp;
import com.hfrsoussama.mymvpapp.repository.network.endpoints.WebServiceEndPoints;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oussama on 02/01/2018.
 */

public class MyJokesInteractorImpl implements MyJokesInteractor {

    @Inject
    WebServiceEndPoints mWebServiceEndPoints;

    private CompositeDisposable mCompositeDisposable;

    public MyJokesInteractorImpl() {
        MyMvpApp.getNetworkingComponent().inject(this);
        mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void fetchJokes(OnFetchJokesListener listener) {
        mCompositeDisposable.add(mWebServiceEndPoints.getAllChuckNorrisJokes()
                .subscribeOn(Schedulers.io())
                .map(chuckNorrisJsonResponse -> chuckNorrisJsonResponse.getJokeList())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        jokeList -> listener.onSuccessFetchingJokes(jokeList),
                        throwable -> listener.onErrorFetchingJokes(throwable)
                )
        );
    }

    @Override
    public void clearDisposables() {
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

}
