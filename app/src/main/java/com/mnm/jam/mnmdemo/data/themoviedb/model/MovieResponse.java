package com.mnm.jam.mnmdemo.data.themoviedb.model;

import com.mnm.jam.mnmdemo.data.themoviedb.TheMovieDbAdapter;
import com.mnm.jam.mnmdemo.domain.model.Movie;

import java.util.List;

/**
 *  @author Javi 05/06/2018
 *
 *  Class to keep the list of movie data
 *  <p>
 *  This class is used by {@link TheMovieDbAdapter} in order to encapsulate de data
 */
public class MovieResponse {

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    private int total_results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    private List<Movie> results;

}
