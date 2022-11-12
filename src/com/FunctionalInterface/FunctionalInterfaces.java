package com.FunctionalInterface;

//When there is single abstract method we call as Functional Interface
// we can't have more than one abstract method


@FunctionalInterface
public interface FunctionalInterfaces {
    void printing();
//    void printing2();   // => ERROR b/c we can't have more than one abstract method in Functional Interface

    //we can have default methods though
    default public void printing2(){
        System.out.println("Default method in Functional Interface");
    }
}
