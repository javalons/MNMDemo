package com.mnm.jam.mnmdemo.data.themoviedb;

import com.mnm.jam.mnmdemo.data.themoviedb.model.MovieResponse;
import com.mnm.jam.mnmdemo.domain.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 *  @author Javi 05/06/2018
 *
 *  Service for networking
 *  <p>
 *  This class is used by {@link TheMovieDbAdapter} to call the different queries
 **/

public interface TheMovieDbService {

    @Headers("content-type: application/json;charset=utf-8")
    @GET("4/discover/movie")
    Call<MovieResponse> getMoviesList(@Query("sort_by") String sort, @Query("page") int page, @Query("api_key") String key);

    @Headers("content-type: application/json;charset=utf-8")
    @GET("4/search/movie")
    Call<MovieResponse> getMoviesList(@Query("include_adult") String sort, @Query("page") int page, @Query("api_key") String key, @Query("query") String query);

}
