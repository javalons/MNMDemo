package com.mnm.jam.mnmdemo.ui.movie;


import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.Presenter;
import com.mnm.jam.mnmdemo.ui.activity.Navigator;

/**
 *  @author Javi 05/06/2018
 *
 *  This class is in charge to do the logic
 *  <p>
 *  This class is used by {@link MovieView}
 */
public class MoviePresenter extends Presenter<MovieView>  implements MovieContract.Presenter{

  private Navigator navigator;

  public MoviePresenter(Navigator navigator) {
    this.navigator = navigator;
  }

  @Override
  public void onMovieAvailable() {
    view.drawMovie();
  }
  @Override
  public void onComicClicked(Movie movie) {
    navigator.goToDetailView(movie);
  }
}
