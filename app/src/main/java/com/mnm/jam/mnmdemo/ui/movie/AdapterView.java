package com.mnm.jam.mnmdemo.ui.movie;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.mnm.jam.mnmdemo.MNMApplication;
import com.mnm.jam.mnmdemo.R;
import com.mnm.jam.mnmdemo.di.component.ApplicationComponent;
import com.mnm.jam.mnmdemo.ui.Presenter;
import com.mnm.jam.mnmdemo.ui.View;

import butterknife.ButterKnife;


/**
 *  @author Javi 05/06/2018
 *
 *  Adapter view is used for views that lives in adapters, every view in the adapter
 *  have a presenter to manage the actions
 *  <p>
 *  This class is father of {@link MovieView}
 */
public abstract class AdapterView implements View {

    protected Context context;
    protected android.view.View view;
    protected ViewGroup viewGroup;
    private int mLayout;
    private Presenter mPresenter;

    public AdapterView(Context context, ViewGroup viewGroup) {
        this.context = context;
        this.viewGroup = viewGroup;
        initDaggerComponent();
        mPresenter = bindPresenter();
        if(mPresenter==null) {
            Log.e(context.getString(R.string.null_pointer),context.getPackageResourcePath() + " null presenter");
            return;
        }
        initView();
        if(view==null) {
            Log.e(context.getString(R.string.null_pointer),context.getPackageResourcePath() + " null presenter");
            return;
        }
        ButterKnife.bind(this, view);
        mPresenter.attachView(this);
        mPresenter.onViewReady();
    }

    private void initView() {
        mLayout = bindLayout();
        this.view = LayoutInflater.from(context).inflate(mLayout, viewGroup, false);
    }

    public abstract Presenter bindPresenter();

    public abstract int bindLayout();

    private void initDaggerComponent() {
        ApplicationComponent applicationComponent =
                ((MNMApplication) context.getApplicationContext()).getApplicationComponent();

        initDaggerComponent(applicationComponent);
    }

    public abstract void initDaggerComponent(ApplicationComponent applicationComponent);

    public android.view.View getView() {
        return view;
    }
}
