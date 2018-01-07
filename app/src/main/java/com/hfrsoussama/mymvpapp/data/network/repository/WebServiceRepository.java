package com.hfrsoussama.mymvpapp.data.network.repository;

import com.hfrsoussama.mymvpapp.BuildConfig;
import com.hfrsoussama.mymvpapp.data.network.model.ChuckNorrisJsonResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Oussama on 28/12/2017.
 */

public interface WebServiceRepository {

    @GET(BuildConfig.JOKES_API_BASE_URL + "jokes")
    Observable<ChuckNorrisJsonResponse> getAllChuckNorrisJokes();

}
