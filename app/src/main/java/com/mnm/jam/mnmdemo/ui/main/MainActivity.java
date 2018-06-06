package com.mnm.jam.mnmdemo.ui.main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.mnm.jam.mnmdemo.R;
import com.mnm.jam.mnmdemo.di.component.ApplicationComponent;
import com.mnm.jam.mnmdemo.di.component.DaggerMainViewComponent;
import com.mnm.jam.mnmdemo.di.component.MainViewComponent;
import com.mnm.jam.mnmdemo.di.module.MainViewModule;
import com.mnm.jam.mnmdemo.domain.model.Movie;
import com.mnm.jam.mnmdemo.ui.Presenter;
import com.mnm.jam.mnmdemo.ui.activity.BaseActivity;
import com.mnm.jam.mnmdemo.ui.movies.adapter.MoviesAdapter;
import com.mnm.jam.mnmdemo.ui.movies.adapter.ScrollRecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 *  @author Javi 05/06/2018
 *
 *  Class wich show the most populars movies
 *  <p>
 *  This class is used by {@link MainPresenter}
 */
public class MainActivity extends BaseActivity  implements MainContract.View{

    MainViewComponent mainViewComponent;
    protected ScrollRecyclerView scrollRecyclerView;

    @BindView(R.id.movies_recycler_view) protected RecyclerView mRecyclerView;
    @BindView(R.id.toolbar) protected Toolbar toolbar;
    @BindView(R.id.drawer_layout) protected DrawerLayout drawerLayout;
    @BindView(R.id.loading) protected ProgressBar loading;

    private MoviesAdapter mMoviesAdapter;
    private StaggeredGridLayoutManager mLayoutManagerGrid;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Inject
    protected MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);

        actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,
                        R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        actionBarDrawerToggle.syncState();

    }


    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.onViewReady();

    }

    @Override
    public Presenter bindPresenter() {
        return mainPresenter;
    }

    @Override
    public boolean isShowingComics() {
        return mMoviesAdapter.getItemCount() > 0;
    }

    @Override
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(View.INVISIBLE);
    }


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initDaggerComponent(ApplicationComponent applicationComponent)
    {
        mainViewComponent = DaggerMainViewComponent.builder()
                .applicationComponent(applicationComponent)
                .mainViewModule(new MainViewModule())
                .build();

        mainViewComponent.inject(this);
    }

    @Override
    public void showMovies(List<Movie> movieList) {

        if(mMoviesAdapter==null)
        {
            Log.e(getString(R.string.null_pointer),this.getLocalClassName() + " null movie adapter");
            return;
        }
        mMoviesAdapter.addMovies(movieList);
    }

    /**
     * Method to set the RecyclerView configuration and manage the events
     */
    protected void manageRecyclerView()
    {

        if(mRecyclerView==null)
        {
            Log.e(getString(R.string.null_pointer),this.getLocalClassName() + " null recycler view");
            return;
        }

        mRecyclerView.setHasFixedSize(true);
        mLayoutManagerGrid = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManagerGrid);

        // set adapter
        mMoviesAdapter = new MoviesAdapter(this);
        mRecyclerView.setAdapter(mMoviesAdapter);

        // Get the scroll events
        scrollRecyclerView = new ScrollRecyclerView(mLayoutManagerGrid)
        {
            @Override
            protected void loadMoreItems(int page){mainPresenter.fetchMoreComics(page);}

            @Override
            public int getTotalPageCount() {
                return 0;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return false;
            }
        };
        mRecyclerView.addOnScrollListener(scrollRecyclerView);
    }




}
