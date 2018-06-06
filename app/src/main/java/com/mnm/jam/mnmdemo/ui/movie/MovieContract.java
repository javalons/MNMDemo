package com.mnm.jam.mnmdemo.ui.movie;

import com.mnm.jam.mnmdemo.domain.model.Movie;

import java.util.List;

/**
 * @author Javi 05/06/2018.
 */

public interface MovieContract {

    interface View {
        void drawMovie();
    }

    interface Presenter  {
        void onMovieAvailable();
        void onComicClicked(Movie movie);
    }

}
