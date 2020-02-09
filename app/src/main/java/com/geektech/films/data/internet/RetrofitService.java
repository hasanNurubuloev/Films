package com.geektech.films.data.internet;

import com.geektech.films.data.entity.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("http://www.omdbapi.com/")
    Call<Example> fetchFilm(@Query("t") String name,
                            @Query("apikey") String apikey);

}
