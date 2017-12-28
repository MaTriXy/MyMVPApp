package com.hfrsoussama.mymvpapp.features.main;

import com.hfrsoussama.mymvpapp.repository.network.model.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oussama on 17/12/2017.
 */

public class MainInteractorImpl implements MainInteractor {

    @Override
    public void fetchCoutriesList(OnFetchCountriesListener listener) {
        List<Country> countryList = new ArrayList<>();
        countryList.add(new Country("France", "Romantic"));
        countryList.add(new Country("London", "Foggy"));
        countryList.add(new Country("Spain", "worm"));
        countryList.add(new Country("Italy", "Dynamic"));
        countryList.add(new Country("Germany", "Engineers"));

        if (countryList == null)
            listener.onError();
        else
            listener.onSuccess(countryList);

    }
}
