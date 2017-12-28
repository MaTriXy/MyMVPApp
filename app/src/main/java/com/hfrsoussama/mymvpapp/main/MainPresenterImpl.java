package com.hfrsoussama.mymvpapp.main;

import com.hfrsoussama.mymvpapp.repository.model.Country;

import java.util.List;

/**
 * Created by Oussama on 17/12/2017.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnFetchCountriesListener {

    private MainView mMainView;
    private MainInteractor mMainInteractor;

    public MainPresenterImpl(MainView mainView) {
        mMainView = mainView;
        mMainInteractor = new MainInteractorImpl();
    }

    @Override
    public void loadCoutriesList() {
        mMainInteractor.fetchCoutriesList(this);
    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onError() {
        if (mMainView != null)
            mMainView.showError();
    }

    @Override
    public void onSuccess(List<Country> listOfCountries) {
        if (mMainView != null)
            mMainView.showData(listOfCountries);
    }


}
