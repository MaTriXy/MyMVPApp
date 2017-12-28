package com.hfrsoussama.mymvpapp.repository.network.helper;

import com.hfrsoussama.mymvpapp.repository.network.endpoints.WebServiceEndPoints;
import com.hfrsoussama.mymvpapp.repository.network.model.ChuckNorrisResponse;

import io.reactivex.Observable;

/**
 * Created by Oussama on 28/12/2017.
 */

public class ApiHelperImpl implements ApiHelper {

    private WebServiceEndPoints mWebServiceEndPoints;

    public ApiHelperImpl(WebServiceEndPoints webServiceEndPoints) {
        mWebServiceEndPoints = webServiceEndPoints;
    }

    @Override
    public Observable<ChuckNorrisResponse> getAllChuckNorrisJokes() {
        return mWebServiceEndPoints.getAllChuckNorrisJokes();
    }
}
