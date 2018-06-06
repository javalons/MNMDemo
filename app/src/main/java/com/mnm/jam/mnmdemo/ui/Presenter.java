package com.mnm.jam.mnmdemo.ui;



/**
 *  @author Javi 05/06/2018
 *
 *  Base presenter
 */
public abstract class Presenter<T extends View> {

  protected T view;

  /**
   * The view must be attached to the presenter in order to work
   */
  public void attachView(T view) {
    this.view = view;
  }

  /**
   * The onViewReady method is used when the layout has been inflated and the view
   * is fully ready
   */
  public void onViewReady() {
    //Empty
  }
}
