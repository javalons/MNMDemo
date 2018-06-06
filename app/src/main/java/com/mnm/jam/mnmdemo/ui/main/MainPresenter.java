package com.mnm.jam.mnmdemo.ui.main;


import com.mnm.jam.mnmdemo.R;
import com.mnm.jam.mnmdemo.domain.interactor.BaseInteractor;
import com.mnm.jam.mnmdemo.domain.interactor.movies.MoviesInteractor;
import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.Presenter;
import com.mnm.jam.mnmdemo.ui.activity.Navigator;

import java.util.List;

/**
 *  @author Javi 05/06/2018
 *
 *  This class is in charge to do the logic
 *  <p>
 *  This class is used by {@link MainActivity}
 */
public class MainPresenter extends Presenter<MainActivity> implements MainContract.Presenter {


    private MoviesInteractor moviesInteractor;
    private static final int FIRST_PAGE = 1;
    private MoviesCallback moviesCallback;
    private boolean loading = false;


    private Navigator navigator;
    private boolean fistTime = true;

    public MainPresenter(Navigator navigator, BaseInteractor moviesInteractor) {
        this.navigator = navigator;
        this.moviesInteractor = (MoviesInteractor)moviesInteractor;
        init();
    }


    private void init() {
        moviesCallback = new MoviesCallback();
    }

    @Override
    public void onViewReady() {
        super.onViewReady();
        if (fistTime) {
            fistTime = false;

            view.manageRecyclerView();
            if (!view.isShowingComics()) {
                fetchFistMovies();
            }
        }
    }


    public void fetchFistMovies() {
        view.showLoading();
        moviesInteractor.execute(FIRST_PAGE, moviesCallback);
    }

    @Override
    public void fetchMoreComics(int page) {
        if (!loading) {
            loading = true;
            view.showLoading();
            moviesInteractor.execute(page, moviesCallback);
        }
    }

    private class MoviesCallback implements MoviesInteractor.MoviesInteractorCallback {

        @Override
        public void onMovieFetch(List<Movie> moviesList) {

            view.hideLoading();
            loading = false;

            List<Movie> movie = moviesList;

            int page = view.scrollRecyclerView.getPage();
            page++;
            view.scrollRecyclerView.setPage(page);

            view.showMovies(moviesList);
        }

        @Override
        public void onFetchError() {
            view.hideLoading();
            loading = false;
            view.showError(view.getString(R.string.fetch_error));

        }
    }


}
