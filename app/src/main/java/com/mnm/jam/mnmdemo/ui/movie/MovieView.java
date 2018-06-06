package com.mnm.jam.mnmdemo.ui.movie;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mnm.jam.mnmdemo.R;
import com.mnm.jam.mnmdemo.data.themoviedb.TheMovieDbAdapter;
import com.mnm.jam.mnmdemo.di.component.ApplicationComponent;
import com.mnm.jam.mnmdemo.di.component.DaggerMovieComponent;
import com.mnm.jam.mnmdemo.di.component.MovieComponent;
import com.mnm.jam.mnmdemo.di.module.MovieModule;
import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.Presenter;
import com.mnm.jam.mnmdemo.ui.movies.adapter.MoviesAdapter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;


/**
 *  @author Javi 05/06/2018
 *
 *  This class use a single view to show the current movie loaded in the adapter view
 *  <p>
 *  This class is used by {@link MoviesAdapter}
 */
public class MovieView extends AdapterView implements MovieContract.View{

  MovieComponent movieComponent;

  @Inject protected MoviePresenter moviePresenter;
  @BindView(R.id.imageView1) protected ImageView image;
  @BindView(R.id.title) protected TextView title;

  private Movie movie;

  public MovieView(Context context, ViewGroup viewGroup) {
    super(context, viewGroup);
  }

  public void render(Movie movie) {
    this.movie = movie;
    moviePresenter.onMovieAvailable();
  }

  @Override
  public void drawMovie() {
    title.setText(movie.getTitle());

    String url = TheMovieDbAdapter.IMAGE_BASE_URL + movie.getPoster_path();
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.marmedsa_logo)
        .into(image);
  }

  @Override
  public Presenter bindPresenter() {
    return moviePresenter;
  }

  @Override
  public int bindLayout() {
    return R.layout.movie_item_row;
  }

  @Override
  public void initDaggerComponent(ApplicationComponent applicationComponent) {
    movieComponent = DaggerMovieComponent.builder()
            .applicationComponent(applicationComponent)
            .movieModule(new MovieModule())
            .build();

    movieComponent.inject(this);
  }

  @OnClick(R.id.imageView1)
  public void onThumbnailCLick() {
    moviePresenter.onComicClicked(movie);
  }
}
