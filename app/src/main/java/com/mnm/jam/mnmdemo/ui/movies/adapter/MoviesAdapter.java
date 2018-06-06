package com.mnm.jam.mnmdemo.ui.movies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.main.MainActivity;
import com.mnm.jam.mnmdemo.ui.movie.MovieView;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author Javi 05/06/2018
 *
 *  This is the adapter to manage the recycler view which keep the lasts movies
 *  <p>
 *  This class is used by {@link MainActivity}
 */

public class MoviesAdapter extends RecyclerView.Adapter {

  private Context context;
  private List<Movie> movies;

  public MoviesAdapter(Context context) {
    this.context = context;
    this.movies = new ArrayList<>();
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return makeMoviesView(parent);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    Movie movie = movies.get(position);
    ((MovieViewHolder) holder).movieView.render(movie);
  }

  @Override
  public int getItemCount() {
    return movies.size();
  }

  private RecyclerView.ViewHolder makeMoviesView(ViewGroup viewGroup) {
    MovieView movieView = new MovieView(context, viewGroup);
    return new MovieViewHolder(movieView);
  }

  public void addMovie(Movie movie) {
    movies.add(movie);
  }

  public void addMovies(List<Movie> movies) {
    for (Movie movie : movies) {
      addMovie(movie);
    }
    notifyDataSetChanged();
  }

  private class MovieViewHolder extends RecyclerView.ViewHolder {

    protected MovieView movieView;

    public MovieViewHolder(MovieView movieView) {
      super(movieView.getView());
      this.movieView = movieView;
    }
  }
}
