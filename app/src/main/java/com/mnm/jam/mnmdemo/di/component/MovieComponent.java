package com.mnm.jam.mnmdemo.di.component;


import com.mnm.jam.mnmdemo.di.annotaion.ActivityScope;
import com.mnm.jam.mnmdemo.di.module.MovieModule;
import com.mnm.jam.mnmdemo.ui.movie.MovieView;

import dagger.Component;

/**
 * @author Javi 05/06/2018
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = MovieModule.class)
public interface MovieComponent  {
    void inject(MovieView movieView);
}
