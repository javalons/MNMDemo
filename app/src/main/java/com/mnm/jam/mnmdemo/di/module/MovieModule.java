package com.mnm.jam.mnmdemo.di.module;


import com.mnm.jam.mnmdemo.di.annotaion.ActivityScope;
import com.mnm.jam.mnmdemo.ui.activity.Navigator;
import com.mnm.jam.mnmdemo.ui.movie.MoviePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Javi 05/06/2018
 */

@Module
public class MovieModule {

  @ActivityScope
  @Provides
  public MoviePresenter provideComicPresenter(Navigator navigator) {
    return new MoviePresenter(navigator);
  }
}
