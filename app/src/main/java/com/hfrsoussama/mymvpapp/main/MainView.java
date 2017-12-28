package com.hfrsoussama.mymvpapp.main;

import com.hfrsoussama.mymvpapp.repository.model.Country;

import java.util.List;

/**
 * Created by Oussama on 17/12/2017.
 */

public interface MainView {

    void init();

    void showLoading();

    void hideLoading();

    void showError();

    void hideError();

    void showData(List<Country> countriesList);

    void hideData();


}
