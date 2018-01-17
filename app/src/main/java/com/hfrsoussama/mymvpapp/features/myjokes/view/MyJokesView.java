package com.hfrsoussama.mymvpapp.features.myjokes.view;

import com.hfrsoussama.mymvpapp.data.network.model.Joke;

import java.util.List;

/**
 * Created by Oussama on 02/01/2018.
 */

public interface MyJokesView {

     void init();

     void fetchJokes();

     void showJokes(List<Joke> jokeList);

     void hideJokes();

     void showLoading();

     void hideLoading();

     void showError(String errorMessage);

}
