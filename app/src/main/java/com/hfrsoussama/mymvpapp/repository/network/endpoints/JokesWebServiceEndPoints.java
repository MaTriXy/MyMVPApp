package com.hfrsoussama.mymvpapp.repository.network.endpoints;

import com.hfrsoussama.mymvpapp.repository.network.model.ChuckNorrisResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Oussama on 28/12/2017.
 */

public interface JokesWebServiceEndPoints {

    @GET("jokes")
    Observable<ChuckNorrisResponse> getAllChuckNorrisJokes();

}
