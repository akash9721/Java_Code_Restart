package com.java.designPattern.creationalDesignPattern.singletonDesignPattern;

class Singleton{

    //lazy Initialization
    private static Singleton instance;
    private Singleton(){
        System.out.println("\nSingleton object is created");
    }
    public static Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}