package com.hfrsoussama.mymvpapp.main;

/**
 * Created by Oussama on 17/12/2017.
 */

public interface CountryListPresenter {

    void onBindCountryItemAtPosition(int position, CountryItemView countryItemView);

    int getCountryListSize();
}
