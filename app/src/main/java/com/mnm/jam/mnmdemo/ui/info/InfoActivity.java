package com.mnm.jam.mnmdemo.ui.info;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mnm.jam.mnmdemo.R;
import com.mnm.jam.mnmdemo.data.themoviedb.TheMovieDbAdapter;
import com.mnm.jam.mnmdemo.di.component.ApplicationComponent;
import com.mnm.jam.mnmdemo.di.component.DaggerInfoViewComponent;
import com.mnm.jam.mnmdemo.di.component.InfoViewComponent;
import com.mnm.jam.mnmdemo.di.module.InfoViewModule;
import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.Presenter;
import com.mnm.jam.mnmdemo.ui.activity.BaseActivity;
import com.mnm.jam.mnmdemo.ui.movie.MoviePresenter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;


/**
 *  @author Javi 05/06/2018
 *
 *  Class wich show the movie info
 *  <p>
 *  This class is called by {@link MoviePresenter}
 */
public class InfoActivity extends BaseActivity implements InfoContract.View{

    @Inject
    protected InfoPresenter infoPresenter;
    @BindView(R.id.header_image) protected ImageView image;
    @BindView(R.id.title) protected TextView title;
    @BindView(R.id.year) protected TextView year;
    @BindView(R.id.description) protected TextView description;
    @BindView(R.id.no_movie) protected TextView noMovie;

    InfoViewComponent infoViewComponent;

    public static final String MOVIE_KEY = "movie_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        infoPresenter.isMovieAvailable();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void initDaggerComponent(ApplicationComponent applicationComponent) {
        infoViewComponent = DaggerInfoViewComponent.builder()
                .applicationComponent(applicationComponent)
                .infoViewModule(new InfoViewModule())
                .build();

        infoViewComponent.inject(this);
    }

    @Override
    public Presenter bindPresenter() {
        return infoPresenter;
    }

    @Override
    public int bindLayout() {
        return R.layout.movie_info_view;
    }

    @Override
    public void draw(Movie movie) {

        title.setText(movie.getTitle());
        year.setText(movie.getRelease_date());
        description.setText(movie.getOverview());

        String url = TheMovieDbAdapter.IMAGE_BASE_URL + movie.getBackdrop_path();
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.marmedsa_logo)
                .into(image);

    }

    @Override
    public void showNoMovieSelected() {
        noMovie.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNoMovieSelected() {
        noMovie.setVisibility(View.INVISIBLE);
    }
}
