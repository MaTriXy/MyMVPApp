package com.hfrsoussama.mymvpapp.features.myjokes;

import com.hfrsoussama.mymvpapp.MyMvpApp;
import com.hfrsoussama.mymvpapp.repository.network.endpoints.WebServiceEndPoints;
import com.hfrsoussama.mymvpapp.repository.network.model.ChuckNorrisResponse;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oussama on 28/12/2017.
 */

public class MyJokesInteractorImpl implements MyJokesInteractor{

    @Inject
    WebServiceEndPoints mWebServiceEndPoints;

    private CompositeDisposable mCompositeDisposable;


    public MyJokesInteractorImpl() {
        MyMvpApp.getNetworkingComponent().inject(this);
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void fetchJokes(onJokesListFetchListener listener) {
        mCompositeDisposable.add(mWebServiceEndPoints.getAllChuckNorrisJokes()
                .subscribeOn(Schedulers.io())
                .map(ChuckNorrisResponse::getJokeList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        listener::onSuccess,
                        listener::onError
                )
        );
    }

    @Override
    public void clearDisposable() {
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }
}
