package com.java.designPattern.creationalDesignPattern.singletonDesignPattern;

//the Singleton instance is created at the time of class loading, regardless of whether it is used or not.
// It is simple and thread-safe, but may lead to unnecessary resource usage.
public class SingletonEagerInitialization {

    private static SingletonEagerInitialization instance=new SingletonEagerInitialization();

    private SingletonEagerInitialization(){
        System.out.println("\nSingleton eager object");
    }

    public static SingletonEagerInitialization getInstance(){
        return instance;
    }
}
