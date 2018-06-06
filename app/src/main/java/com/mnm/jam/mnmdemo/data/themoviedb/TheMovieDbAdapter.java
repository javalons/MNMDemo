package com.mnm.jam.mnmdemo.data.themoviedb;


import com.mnm.jam.mnmdemo.data.MoviesDataSource;
import com.mnm.jam.mnmdemo.data.themoviedb.model.MovieResponse;
import com.mnm.jam.mnmdemo.domain.interactor.movies.MoviesInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  @author Javi 05/06/2018
 *
 *  Main adapter for networking
 *  <p>
 *  This class is used by {@link MoviesInteractor} to get remote data
 */
public class TheMovieDbAdapter  implements MoviesDataSource {

    public static final String BASE_URL         = "https://api.themoviedb.org/";
    public static final String IMAGE_BASE_URL   = "https://image.tmdb.org/t/p/w500";
    public static final String KEY              = "93aea0c77bc168d8bbce3918cefefa45";


    Retrofit retrofit;
    public TheMovieDbAdapter(){
        retrofit = getAdapter(BASE_URL);
    }

    public Retrofit getAdapter(String sUrl){
        retrofit = new Retrofit.Builder()
                .baseUrl(sUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


    /**
     * Method to get a list of most populars movies
     * @param page
     * @param callback
     */
    @Override
    public void getMovies(int page,Callback<MovieResponse> callback) {
        getMovies(page,"",callback);
    }

    /**
     * Method to get a list of movies by query
     * @param page
     * @param query
     * @param callback
     */
    @Override
    public void getMovies(int page,String query,Callback<MovieResponse> callback)
    {
        Call<MovieResponse> call;
        TheMovieDbService service = retrofit.create(TheMovieDbService.class);

        if(query.isEmpty() || query == null)
            call = service.getMoviesList("popularity.desc",page, KEY);
        else
            call = service.getMoviesList("false",page,KEY,query);
        call.enqueue(callback);
    }

}
