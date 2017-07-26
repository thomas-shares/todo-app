# Simple ToDo app in ClojureScript and Reagent
This is a simple ToDo app in [ClojureScript](https://github.com/clojure/clojurescript)
that uses [Reagent](https://reagent-project.github.io/). It also stores the ToDo list in the [local storage](https://github.com/alandipert/storage-atom) of your browser, so the next time you visit the page the list will still be there.

The list is stored in a set, so you can't have the same item twice in the list.

This app is based on code written by Snugug as published here:
https://codepen.io/Snugug/pen/yOXemR

## Usage
The app uses [boot](http://boot-clj.com/), for development just type the following on the command line:
```boot dev``` and then point your browser at http://localhost:3000

## License

Copyright (C) 2017

Distributed under the Eclipse Public License, the same as Clojure.
