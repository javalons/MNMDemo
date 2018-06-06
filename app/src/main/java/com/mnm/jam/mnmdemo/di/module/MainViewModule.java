package com.mnm.jam.mnmdemo.di.module;


import com.mnm.jam.mnmdemo.data.MoviesDataSource;
import com.mnm.jam.mnmdemo.data.themoviedb.TheMovieDbAdapter;
import com.mnm.jam.mnmdemo.di.annotaion.ActivityScope;
import com.mnm.jam.mnmdemo.domain.interactor.BaseInteractor;
import com.mnm.jam.mnmdemo.domain.interactor.movies.MoviesInteractor;
import com.mnm.jam.mnmdemo.ui.activity.Navigator;
import com.mnm.jam.mnmdemo.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Javi 05/06/2018
 */
@Module
public class MainViewModule {


  @ActivityScope
  @Provides
  public MoviesDataSource provideGetMoviesDataSource() {
    return new TheMovieDbAdapter();
  }

  @ActivityScope
  @Provides
  public BaseInteractor provideGetMoviesInteractor(MoviesDataSource mDataSource) {
    return new MoviesInteractor(mDataSource);
  }

  @ActivityScope
  @Provides
  MainPresenter provideMainPresenter(Navigator navigator, BaseInteractor moviesInteractor) {
    return new MainPresenter(navigator, moviesInteractor);
  }
}
