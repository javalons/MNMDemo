package com.mnm.jam.mnmdemo.domain.interactor.movies;

import com.mnm.jam.mnmdemo.data.MoviesDataSource;
import com.mnm.jam.mnmdemo.data.themoviedb.model.MovieResponse;
import com.mnm.jam.mnmdemo.domain.interactor.BaseInteractor;
import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.main.MainPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  @author Javi 05/06/2018
 *
 *  This class manage the conection with the end point to get the movies
 *  <p>
 *  This class is used by {@link MainPresenter} to get remote data
 */
public class MoviesInteractor implements BaseInteractor {

  private MoviesDataSource moviesDataSource;

  private MoviesInteractorCallback moviesInteractorCallback;

  public MoviesInteractor(MoviesDataSource mDataSource) {
    moviesDataSource = mDataSource;
  }

  @Override
  public void execute(MoviesInteractorCallback moviesInteractorCallback) {
    execute(0,moviesInteractorCallback);
  }

  @Override
  public void execute(int amount, MoviesInteractorCallback moviesInteractorCallback) {
    this.moviesInteractorCallback = moviesInteractorCallback;
    fetch(amount);

  }

@Override
public void fetch(int amount)
{

  Callback<MovieResponse> callback = new Callback<MovieResponse>()
  {

    @Override
    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

      // Think to use a mapper**

      MovieResponse movieRespose = response.body();
      moviesInteractorCallback.onMovieFetch(movieRespose.getResults());
    }

    @Override
    public void onFailure(Call<MovieResponse> call, Throwable t) {
      moviesInteractorCallback.onFetchError();
    }
  };

    moviesDataSource.getMovies(amount,callback);
}


  public interface MoviesInteractorCallback {

    void onMovieFetch(List<Movie> moviesList);

    void onFetchError();
  }
}
