package com.mnm.jam.mnmdemo.di.module;


import com.mnm.jam.mnmdemo.di.annotaion.ActivityScope;
import com.mnm.jam.mnmdemo.ui.info.InfoPresenter;


import dagger.Module;
import dagger.Provides;

/**
 * @author Javi 05/06/2018
 */
@Module
public class InfoViewModule {

  @ActivityScope
  @Provides
  InfoPresenter provideInfoPresenter() {
    return new InfoPresenter();
  }
}
