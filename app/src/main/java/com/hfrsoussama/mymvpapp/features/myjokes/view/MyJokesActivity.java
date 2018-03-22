package com.hfrsoussama.mymvpapp.features.myjokes.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.hfrsoussama.mymvpapp.R;
import com.hfrsoussama.mymvpapp.data.network.model.Joke;
import com.hfrsoussama.mymvpapp.databinding.ActivityMyJokesBinding;
import com.hfrsoussama.mymvpapp.features.myjokes.presenter.MyJokesPresenter;
import com.hfrsoussama.mymvpapp.features.myjokes.presenter.MyJokesPresenterImpl;

import java.util.List;

public class MyJokesActivity extends AppCompatActivity implements MyJokesView {

    private ActivityMyJokesBinding binding;
    private MyJokesPresenter jokesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_jokes);
        jokesPresenter = new MyJokesPresenterImpl(this);

        init();

    }

    @Override
    protected void onDestroy() {
        jokesPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void init() {
        binding.rvJokesList.setLayoutManager(new LinearLayoutManager(this));
        fetchJokes();
    }

    @Override
    public void fetchJokes() {
        hideJokes();
        showLoading();
        jokesPresenter.fetchJokes();
    }

    @Override
    public void showJokes(List<Joke> jokeList) {
        binding.rvJokesList.setVisibility(View.VISIBLE);
        binding.rvJokesList.setAdapter(new JokesListAdapter(jokeList));
        hideLoading();
    }


    @Override
    public void hideJokes() {
        binding.rvJokesList.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoading() {
        binding.pbLoadingJokesList.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.pbLoadingJokesList.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

}
