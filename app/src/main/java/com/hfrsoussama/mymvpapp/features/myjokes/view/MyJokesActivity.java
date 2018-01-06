package com.hfrsoussama.mymvpapp.features.myjokes.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.hfrsoussama.mymvpapp.R;
import com.hfrsoussama.mymvpapp.databinding.ActivityMyJokesBinding;
import com.hfrsoussama.mymvpapp.features.myjokes.presenter.MyJokesPresenter;
import com.hfrsoussama.mymvpapp.features.myjokes.presenter.MyJokesPresenterImpl;
import com.hfrsoussama.mymvpapp.repository.network.model.Joke;

import java.util.List;

public class MyJokesActivity extends AppCompatActivity implements MyJokesView {

    private ActivityMyJokesBinding mBinding;
    private MyJokesPresenter mJokesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_jokes);
        mJokesPresenter = new MyJokesPresenterImpl(this);

        init();

    }

    @Override
    protected void onDestroy() {
        mJokesPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void init() {
        mBinding.rvJokesList.setLayoutManager(new LinearLayoutManager(this));
        fetchJokes();
    }

    @Override
    public void fetchJokes() {
        hideJokes();
        showLoading();
        mJokesPresenter.fetchJokes();
    }

    @Override
    public void showJokes(List<Joke> jokeList) {
        mBinding.rvJokesList.setVisibility(View.VISIBLE);
        mBinding.rvJokesList.setAdapter(new JokesListAdapter(jokeList));
        Log.e("KOKO", jokeList.toString());
        hideLoading();
    }


    @Override
    public void hideJokes() {
        mBinding.rvJokesList.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoading() {
        mBinding.pbLoadingJokesList.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mBinding.pbLoadingJokesList.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError() {
        Log.d("TAG", "ERROR");
    }


}
