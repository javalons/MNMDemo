Android demo application
===

Demo to show the skills as an Android Developer

Application
------------

A small app which connects with the end point of API api.themoviedb.org in order to show the most recent popular movies.

Main points
------------

- The application is developed based on Clean Architecture and MVP UI Pattern.

- The application uses Dagger 2 for dependency injection using different scopes annotations depends on the component.

- The architecture is distributed in four important packages, 
data (for API networking and data model) , di (for dependency injection), 
domain (for uses cases of networking interaction and model data),
ui (wrap all the ui logic based in MVP).

External Libs
------------

- [Retrofit ](http://square.github.io/dagger/)
- [Dagger](http://square.github.io/retrofit/)
- [ButterKnife](http://jakewharton.github.io/butterknife/)
- [Picasso](http://square.github.io/picasso/)

Developed By
------------
Javier Alonso Mayor - <javalons@gmail.com>

- [LinkedIn](https://www.linkedin.com/in/javalons/)
