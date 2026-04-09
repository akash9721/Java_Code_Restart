package com.java.designPattern.creationalDesignPattern.singletonDesignPattern;

import java.io.Serializable;

class Singleton implements Cloneable, Serializable {

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
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}