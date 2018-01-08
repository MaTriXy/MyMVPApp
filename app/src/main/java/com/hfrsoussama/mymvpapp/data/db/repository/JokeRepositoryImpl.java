package com.hfrsoussama.mymvpapp.data.db.repository;

import com.hfrsoussama.mymvpapp.MyMvpApp;
import com.hfrsoussama.mymvpapp.data.db.model.DaoSession;
import com.hfrsoussama.mymvpapp.data.db.model.JokeEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Oussama on 06/01/2018.
 */

public class JokeRepositoryImpl implements JokeRepository{

    @Inject
    DaoSession daoSession;

    public JokeRepositoryImpl() {
    }

    public Observable<JokeEntity> getJokeById(Long id) {
        return Observable.fromCallable(() ->
            MyMvpApp.getDaoSession().getJokeEntityDao().load(id)
        );
    }

    public Observable<Boolean> saveJokesList(List<JokeEntity> jokeList) {
        return Observable.fromCallable(() -> {
            MyMvpApp.getDaoSession().getJokeEntityDao().insertOrReplaceInTx(jokeList);
            return true;
        });
    }
}
