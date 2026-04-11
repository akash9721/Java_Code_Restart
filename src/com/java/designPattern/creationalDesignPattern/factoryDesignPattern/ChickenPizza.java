package com.java.designPattern.creationalDesignPattern.factoryDesignPattern;

public class ChickenPizza implements Pizza{

    @Override
    public void makePizza() {
        System.out.println("Chicken pizza created");
    }
}
