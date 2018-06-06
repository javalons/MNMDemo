package com.mnm.jam.mnmdemo.domain.model;



import com.mnm.jam.mnmdemo.data.themoviedb.model.MovieResponse;

import java.io.Serializable;

/**
 *  @author Javi 05/06/2018
 *
 *  Class to keep the movie data
 *  <p>
 *  This class is used by {@link MovieResponse} to keep a list of movies data
 */
public class Movie implements Serializable {

    private String title;

    private String release_date;

    private String overview;

    private String backdrop_path;

    private String poster_path;

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }


}
