package com.mnm.jam.mnmdemo.di.component;



import com.mnm.jam.mnmdemo.di.annotaion.ActivityScope;
import com.mnm.jam.mnmdemo.di.module.MainViewModule;
import com.mnm.jam.mnmdemo.ui.main.MainActivity;

import dagger.Component;

/**
 * @author Javi 05/06/2018
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = MainViewModule.class)
public interface MainViewComponent {

  void inject(MainActivity mainView);
}
