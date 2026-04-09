package com.java.designPattern.creationalDesignPattern.singletonDesignPattern;

public enum SingletonUsingEnum {
    INSTANCE;

    public void doSomething(){
        System.out.println("Singleton using enum");
    }
}
