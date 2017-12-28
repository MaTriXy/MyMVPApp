package com.hfrsoussama.mymvpapp.features.myjokes;

import com.hfrsoussama.mymvpapp.repository.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 28/12/2017.
 */

public interface MyJokesView {

    void showLoading();

    void hideLoading();

    void getMyJokes();

    void showMyJokes(List<Joke> jokeList);

    void hideMyJokes();

}
