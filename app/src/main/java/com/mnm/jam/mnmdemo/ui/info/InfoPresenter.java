package com.mnm.jam.mnmdemo.ui.info;

import android.content.Intent;

import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.Presenter;
import com.mnm.jam.mnmdemo.ui.main.MainActivity;
import com.mnm.jam.mnmdemo.ui.main.MainPresenter;

/**
 *  @author Javi 05/06/2018
 *
 *  This class is in charge to do the logic
 *  <p>
 *  This class is used by {@link InfoActivity}
 */
public class InfoPresenter extends Presenter<InfoActivity> implements  InfoContract.Presenter{

    public InfoPresenter() {
        init();
    }

    private void init() {

    }

    @Override
    public void onViewReady() {
        super.onViewReady();
        view.showNoMovieSelected();
    }

    @Override
    public void isMovieAvailable()
    {

        Intent intent = view.getIntent();
        Movie movie = (Movie) intent.getExtras().getSerializable(view.MOVIE_KEY);

        if(movie==null)
            return;

        view.hideNoMovieSelected();
        view.draw(movie);
    }

}
