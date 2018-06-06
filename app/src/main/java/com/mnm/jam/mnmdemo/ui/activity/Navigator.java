package com.mnm.jam.mnmdemo.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.info.InfoActivity;
import com.mnm.jam.mnmdemo.ui.main.MainPresenter;
import com.mnm.jam.mnmdemo.ui.movie.MoviePresenter;

/**
 *  @author Javi 05/06/2018
 *
 *  Manage the activity funtion of navigation
 *  <p>
 *  This class is used by {@link MainPresenter} and {@link MoviePresenter}
 */
public class Navigator {

    Activity mActivity;
    public Navigator()
    {
    }

    public Activity getActivity() {
        return mActivity;
    }

    public void setActivity(Activity mActivity) {
        this.mActivity = mActivity;
    }


    public void goToDetailView(Movie movie) {
            Intent intent = new Intent(mActivity, InfoActivity.class);
            intent.putExtra(InfoActivity.MOVIE_KEY, movie);
            mActivity.startActivity(intent);
    }
}
