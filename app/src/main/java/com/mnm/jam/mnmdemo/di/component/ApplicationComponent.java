package com.mnm.jam.mnmdemo.di.component;


import com.mnm.jam.mnmdemo.MNMApplication;
import com.mnm.jam.mnmdemo.di.module.ActivityModule;
import com.mnm.jam.mnmdemo.di.module.ApplicationModule;
import com.mnm.jam.mnmdemo.ui.activity.Navigator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Javi 05/06/2018
 */

@Singleton
@Component(modules = {ApplicationModule.class, ActivityModule.class})
public interface ApplicationComponent {

    void inject(MNMApplication mnmApplication);

    Navigator navigator();

}


