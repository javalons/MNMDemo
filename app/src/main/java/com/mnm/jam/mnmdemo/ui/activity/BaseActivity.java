package com.mnm.jam.mnmdemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.mnm.jam.mnmdemo.MNMApplication;
import com.mnm.jam.mnmdemo.R;
import com.mnm.jam.mnmdemo.data.themoviedb.model.MovieResponse;
import com.mnm.jam.mnmdemo.di.component.ApplicationComponent;
import com.mnm.jam.mnmdemo.ui.Presenter;
import com.mnm.jam.mnmdemo.ui.info.InfoActivity;
import com.mnm.jam.mnmdemo.ui.main.MainActivity;

import butterknife.ButterKnife;

/**
 *  @author Javi 05/06/2018
 *
 *  Abstract base class to do the common activities tasks
 *  <p>
 *  This class is father of {@link MainActivity} and {@link InfoActivity}
 */
public abstract class BaseActivity extends AppCompatActivity implements com.mnm.jam.mnmdemo.ui.View {

    Presenter mPresenter;
    private int layout;
    protected View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void init() {
        initDaggerComponent();
        mPresenter = bindPresenter();

        if(mPresenter==null) {
            Log.e(getString(R.string.null_pointer),this.getLocalClassName() + " null presenter");
            return;
        }
        layout = bindLayout();

        mPresenter.attachView(this);
        view = getLayoutInflater().inflate(layout, null);
        if(view==null) {
            Log.e(getString(R.string.null_pointer),this.getLocalClassName() + "null view");
            return;
        }

        setContentView(view);
        ButterKnife.bind(this);
    }


    private void initDaggerComponent() {

        ApplicationComponent applicationComponent =
            ((MNMApplication) getApplication()).getApplicationComponent();

        initDaggerComponent(applicationComponent);

    }

    public void showError(String error) {
        Snackbar.make(view, error, Snackbar.LENGTH_SHORT).show();
    }

    public abstract void initDaggerComponent(ApplicationComponent applicationComponent);

    public abstract Presenter bindPresenter();

    public abstract int bindLayout();


}
