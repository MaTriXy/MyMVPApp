package com.hfrsoussama.mymvpapp.data.db.repository;

import com.hfrsoussama.mymvpapp.data.db.model.JokeEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Oussama on 07/01/2018.
 */

public interface JokeRepository {

    Observable<JokeEntity> getJokeById(Long id);

    Observable<Boolean> saveJokesList(List<JokeEntity> jokeList);
}
