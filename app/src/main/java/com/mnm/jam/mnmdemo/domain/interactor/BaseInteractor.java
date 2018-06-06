package com.mnm.jam.mnmdemo.domain.interactor;


import com.mnm.jam.mnmdemo.domain.interactor.movies.MoviesInteractor;
import com.mnm.jam.mnmdemo.domain.model.Movie;

import java.util.List;

/**
 *  @author Javi 05/06/2018
 */
public interface BaseInteractor {

  void execute(MoviesInteractor.MoviesInteractorCallback moviesInteractorCallback);

  void execute(int amount, MoviesInteractor.MoviesInteractorCallback moviesInteractorCallback);

  void fetch(int amont);

}
