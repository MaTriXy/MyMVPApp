package com.hfrsoussama.mymvpapp.repository.network.endpoints;

import com.hfrsoussama.mymvpapp.BuildConfig;
import com.hfrsoussama.mymvpapp.repository.network.model.ChuckNorrisJsonResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Oussama on 28/12/2017.
 */

public interface WebServiceEndPoints {

    @GET(BuildConfig.JOKES_API_BASE_URL + "jokes")
    Observable<ChuckNorrisJsonResponse> getAllChuckNorrisJokes();

}
