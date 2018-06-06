package com.mnm.jam.mnmdemo.data;

import com.mnm.jam.mnmdemo.data.themoviedb.model.MovieResponse;
import com.mnm.jam.mnmdemo.domain.model.Movie;

import java.util.List;

import retrofit2.Callback;

/**
 * @author Javi 05/06/2018
 */

public interface MoviesDataSource {

    public void getMovies(int page, Callback<MovieResponse> callback);

    public void getMovies(int page,String query,Callback<MovieResponse> callback);
}
