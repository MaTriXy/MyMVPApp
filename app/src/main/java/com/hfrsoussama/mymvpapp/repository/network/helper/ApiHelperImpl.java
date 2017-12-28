package com.hfrsoussama.mymvpapp.repository.network.helper;

import com.hfrsoussama.mymvpapp.repository.network.endpoints.JokesWebServiceEndPoints;
import com.hfrsoussama.mymvpapp.repository.network.model.ChuckNorrisResponse;

import io.reactivex.Observable;

/**
 * Created by Oussama on 28/12/2017.
 */

public class ApiHelperImpl implements ApiHelper {

    JokesWebServiceEndPoints mJokesWebServiceEndPoints;

    public ApiHelperImpl(JokesWebServiceEndPoints jokesWebServiceEndPoints) {
        mJokesWebServiceEndPoints = jokesWebServiceEndPoints;
    }

    @Override
    public Observable<ChuckNorrisResponse> getAllChuckNorrisJokes() {
        return mJokesWebServiceEndPoints.getAllChuckNorrisJokes();
    }
}
