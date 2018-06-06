package com.mnm.jam.mnmdemo.di.component;


import com.mnm.jam.mnmdemo.di.annotaion.ActivityScope;
import com.mnm.jam.mnmdemo.di.module.InfoViewModule;
import com.mnm.jam.mnmdemo.ui.info.InfoActivity;

import dagger.Component;

/**
 * @author Javi 05/06/2018
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = InfoViewModule.class)
public interface InfoViewComponent{

  void inject(InfoActivity infoView);
}
