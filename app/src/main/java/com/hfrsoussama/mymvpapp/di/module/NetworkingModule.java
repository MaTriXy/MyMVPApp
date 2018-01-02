package com.hfrsoussama.mymvpapp.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hfrsoussama.mymvpapp.repository.network.endpoints.WebServiceEndPoints;
import com.hfrsoussama.mymvpapp.repository.network.helper.ApiHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Oussama on 20/12/2017.
 */

@Module
public class NetworkingModule {

    private String mBaseUrl;

    public NetworkingModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }


    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
         return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    WebServiceEndPoints provideWebServiceEndPoints(Retrofit retrofit) {
        return retrofit.create(WebServiceEndPoints.class);
    }

    @Provides
    @Singleton
    ApiHelperImpl provideApiHelperImpl(WebServiceEndPoints webServiceEndPoints) {
        return new ApiHelperImpl(webServiceEndPoints);
    }
}
