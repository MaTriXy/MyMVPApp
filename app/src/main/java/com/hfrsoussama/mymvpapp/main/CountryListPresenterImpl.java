package com.hfrsoussama.mymvpapp.main;

import com.hfrsoussama.mymvpapp.data.model.Country;

import java.util.List;

/**
 * Created by Oussama on 17/12/2017.
 */

public class CountryListPresenterImpl implements CountryListPresenter {

    private List<Country> mCountryList;

    public CountryListPresenterImpl(List<Country> countryList) {
        mCountryList = countryList;
    }

    @Override
    public void onBindCountryItemAtPosition(int position, CountryItemView countryItemView) {
        Country country = mCountryList.get(position);
        countryItemView.setTitle(country.getTitle());
        countryItemView.setDetails(country.getDetail());
    }

    @Override
    public int getCountryListSize() {
        return mCountryList.size();
    }

}
