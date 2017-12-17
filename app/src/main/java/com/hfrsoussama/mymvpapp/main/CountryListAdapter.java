package com.hfrsoussama.mymvpapp.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hfrsoussama.mymvpapp.R;

/**
 * Created by Oussama on 17/12/2017.
 */

public class CountryListAdapter extends RecyclerView.Adapter<CountryItemViewHolder> {

    private final CountryListPresenter mCountryListPresenter;

    public CountryListAdapter(CountryListPresenter countryListPresenter) {
        mCountryListPresenter = countryListPresenter;
    }

    @Override
    public CountryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country_card, parent, false);
        return new CountryItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryItemViewHolder holder, int position) {
        mCountryListPresenter.onBindCountryItemAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return mCountryListPresenter.getCountryListSize();
    }
}
