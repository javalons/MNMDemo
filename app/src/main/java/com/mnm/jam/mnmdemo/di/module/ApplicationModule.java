package com.mnm.jam.mnmdemo.di.module;

import android.content.Context;
import com.mnm.jam.mnmdemo.MNMApplication;
import com.mnm.jam.mnmdemo.ui.activity.Navigator;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * The base modul application , build in application main class in order to be accessible
 *
 * @author Javi 05/06/2018
 */
@Module public class ApplicationModule {

  private final MNMApplication application;

  public ApplicationModule(MNMApplication mnmApplication) {
    this.application = mnmApplication;
  }

  @Singleton
  @Provides
  Context provideApplicationContext() {
    return this.application;
  }

  @Singleton
  @Provides
  Navigator provideNavigator() {
    return new Navigator();
  }


}
