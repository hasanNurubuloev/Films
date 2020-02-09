package com.geektech.films.data.internet;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {
    public static RetrofitService service;


    public static RetrofitService getService () {
        if (service == null) {
            service = builderRetrofit();
        }
        return service;
    }
    private static RetrofitService builderRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService.class);

    }

}
