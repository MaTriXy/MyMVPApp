package com.hfrsoussama.mymvpapp.features.myjokes;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hfrsoussama.mymvpapp.R;
import com.hfrsoussama.mymvpapp.databinding.ActivityMyJokesBinding;
import com.hfrsoussama.mymvpapp.repository.network.model.Joke;

import java.util.List;

public class MyJokesActivity extends AppCompatActivity implements MyJokesView {

    private ActivityMyJokesBinding mBinding;
    private MyJokesPresenter mMyJokesPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_jokes);
        mMyJokesPresenter = new MyJokesPrensenterImpl(this, new MyJokesInteractorImpl());

        getMyJokes();
    }

    @Override
    public void showLoading() {
        hideMyJokes();
        mBinding.pbLoadingMyJokes.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mBinding.pbLoadingMyJokes.setVisibility(View.INVISIBLE);
    }

    @Override
    public void getMyJokes() {
        mMyJokesPresenter.fetchJokesList();
    }

    @Override
    public void showMyJokes(List<Joke> jokeList) {
        hideLoading();
        mBinding.tvJokesList.setVisibility(View.VISIBLE);
        mBinding.tvJokesList.setText(jokeList.toString());
    }

    @Override
    public void hideMyJokes() {
        mBinding.tvJokesList.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onDestroy() {
        mMyJokesPresenter.onDestroy();
        super.onDestroy();
    }
}
