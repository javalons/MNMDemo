package com.mnm.jam.mnmdemo.ui.info;

import com.mnm.jam.mnmdemo.domain.model.Movie;

/**
 * @author Javi 05/06/2018.
 */

public interface InfoContract {

    interface View {
        void draw(Movie movie);
        void showNoMovieSelected();
        void hideNoMovieSelected();
    }

    interface Presenter  {
        void isMovieAvailable();
    }
}
