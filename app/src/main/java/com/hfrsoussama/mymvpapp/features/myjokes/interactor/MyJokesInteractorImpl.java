package com.hfrsoussama.mymvpapp.features.myjokes.interactor;

import com.hfrsoussama.mymvpapp.MyMvpApp;
import com.hfrsoussama.mymvpapp.data.db.model.JokeEntity;
import com.hfrsoussama.mymvpapp.data.db.repository.JokeRepository;
import com.hfrsoussama.mymvpapp.data.db.repository.JokeRepositoryImpl;
import com.hfrsoussama.mymvpapp.data.network.repository.WebServiceRepository;
import com.hfrsoussama.mymvpapp.data.network.model.Joke;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Oussama on 02/01/2018.
 */

public class MyJokesInteractorImpl implements MyJokesInteractor {

    @Inject
    WebServiceRepository mWebServiceRepository;

    JokeRepository mJokeRepository;

    private CompositeDisposable mCompositeDisposable;

    public MyJokesInteractorImpl() {
        MyMvpApp.getNetworkingComponent().inject(this);
        mJokeRepository = new JokeRepositoryImpl();
        mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void fetchJokes(OnFetchJokesListener listener) {
        mCompositeDisposable.add(mWebServiceRepository.getAllChuckNorrisJokes()
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
    public void persisteJokes(List<Joke> jokeList, OnPersistListener listener) {
        mCompositeDisposable.add(ObservableFromIterable.fromIterable(jokeList)
                .subscribeOn(Schedulers.io())
                .take(50)
                .flatMapIterable(jokeEntityList -> jokeList)
                .map(JokeEntity::fromJoke)
                .toList()
                .map(jokeEntities -> mJokeRepository.saveJokesList(jokeEntities))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        booleanObservable -> listener.onSuccessPersisting(),
                        throwable -> listener.onErrorPersisting(throwable)
                )
        );
    }

    @Override
    public void clearDisposables() {
        if (mCompositeDisposable != null)
            mCompositeDisposable.clear();
    }

}
