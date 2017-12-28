package com.hfrsoussama.mymvpapp.features.main;

import com.hfrsoussama.mymvpapp.repository.network.model.Country;

import java.util.List;

/**
 * Created by Oussama on 17/12/2017.
 */

public interface MainInteractor {

    interface OnFetchCountriesListener {

        void onError();

        void onSuccess(List<Country> listOfCountries);
    }

    void fetchCoutriesList(OnFetchCountriesListener listener);
}
