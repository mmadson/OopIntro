package com.github.mmadson.oopdemo;

class TableOfContents {

    public static void main(String[] args) throws Exception {







        // The Goal of this talk is to provide an introduction
        // to Object Oriented Programming (and later, Functional Programming)
        // so that relatively new developers can understand and
        // identify the paradigm(s) as well as to understand the problems
        // each paradigm aims to solve.

        // This is not a best practices talk or a system architecture
        // talk, so don't look at this code as an example of how one
        // should structure an Object Oriented application.







        CreatingAndUsingObjects.demo();

        DefiningObjects.demo();











        // Some final thoughts on OO:

        // Mutable state, regardles of whether or not it's encapsulated
        // can cause problems when mutations occur concurrently.
        // There are ways to avoid concurrent modificaitons but most involve
        // complex synronization logic or concurrent datastructurs.
        // If done incorrectly, the resulting bugs can be catastrophic;
        // including race conditions and deadlock.
        // As CPU architectures move more toward multiple cores instead of
        // faster processors; the need to leverage concurrency in your
        // applications to continue benefiting from the hardware increases.
        // The best way to design highly concurrent code is to not modify
        // state. This can be done in OO by only modeling Immutable objects,
        // however, this can also be done using pure functional programming.










    }
}
