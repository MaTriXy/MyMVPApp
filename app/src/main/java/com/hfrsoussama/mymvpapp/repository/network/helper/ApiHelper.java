package com.hfrsoussama.mymvpapp.repository.network.helper;

import com.hfrsoussama.mymvpapp.repository.network.model.ChuckNorrisResponse;

import io.reactivex.Observable;

/**
 * Created by Oussama on 28/12/2017.
 */

public interface ApiHelper {

        Observable<ChuckNorrisResponse> getAllChuckNorrisJokes();
}
