package com.mnm.jam.mnmdemo.di.annotaion;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Javi 05/06/2018
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}