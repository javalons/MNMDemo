package com.mnm.jam.mnmdemo.ui.main;

import com.mnm.jam.mnmdemo.domain.model.Movie;

import java.util.List;

/**
 * Created by Javi on 05/06/2018.
 */

public interface MainContract {

    interface View {
        void showLoading();
        void hideLoading();
        boolean isShowingComics();
        void showMovies(List<Movie> movieList);
    }

    interface Presenter  {
        void fetchMoreComics(int page);
    }

}
