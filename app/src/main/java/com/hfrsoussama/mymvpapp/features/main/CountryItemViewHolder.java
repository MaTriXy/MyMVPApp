package com.hfrsoussama.mymvpapp.features.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hfrsoussama.mymvpapp.R;

/**
 * Created by Oussama on 17/12/2017.
 */

public class CountryItemViewHolder extends RecyclerView.ViewHolder implements CountryItemView {

    private TextView titleTextView;
    private TextView detailTextView;

    public CountryItemViewHolder(View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.tv_title_item_country_card);
        detailTextView = itemView.findViewById(R.id.tv_details_item_country_card);
    }

    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void setDetails(String details) {
        detailTextView.setText(details);
    }
}
