package com.mnm.jam.mnmdemo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.mnm.jam.mnmdemo.di.component.ApplicationComponent;
import com.mnm.jam.mnmdemo.di.component.DaggerApplicationComponent;
import com.mnm.jam.mnmdemo.di.module.ApplicationModule;
import com.mnm.jam.mnmdemo.ui.activity.Navigator;

import javax.inject.Inject;

/**
 * @author Javi 05/06/2018
 */
public class MNMApplication extends Application implements Application.ActivityLifecycleCallbacks {

    @Inject
    protected Navigator navigator;
    private ApplicationComponent applicationComponent;


    @Override
    public void onCreate(){
        super.onCreate();
        buildApplicationComponent();
        inject();
        this.registerActivityLifecycleCallbacks(this);
    }

    private void buildApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    private void inject() {
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        navigator.setActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
