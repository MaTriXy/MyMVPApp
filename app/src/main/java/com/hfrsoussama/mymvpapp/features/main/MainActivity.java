package com.hfrsoussama.mymvpapp.features.main;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.hfrsoussama.mymvpapp.R;
import com.hfrsoussama.mymvpapp.repository.network.model.Country;
import com.hfrsoussama.mymvpapp.databinding.ActivityMainBinding;

import java.util.List;

/**
 * Created by Oussama on 16/12/2017.
 */

public class MainActivity extends Activity implements MainView {

    private ActivityMainBinding mBinding;
    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainPresenter = new MainPresenterImpl(this);
        init();
    }

    @Override
    public void init() {
        hideData();
        hideError();
        showLoading();
        mMainPresenter.loadCoutriesList();
    }

    @Override
    public void showLoading() {
        mBinding.pbLoadingMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mBinding.pbLoadingMain.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError() {
        hideLoading();
        mBinding.tvErrorMessageMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideError() {
        mBinding.tvErrorMessageMain.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showData(List<Country> countriesList) {
        hideLoading();
        hideError();
        mBinding.rvCoutriesListMain.setVisibility(View.VISIBLE);

        mBinding.rvCoutriesListMain.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvCoutriesListMain.setAdapter(
                new CountryListAdapter(new CountryListPresenterImpl(countriesList))
        );
    }

    @Override
    public void hideData() {
        mBinding.rvCoutriesListMain.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onDestroy() {
        mMainPresenter.onDestroy();
        super.onDestroy();
    }
}
