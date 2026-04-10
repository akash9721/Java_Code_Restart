package com.java.designPattern.creationalDesignPattern.singletonDesignPattern.factoryDesignPattern;

public class CheesePizza implements Pizza{
    @Override
    public void makePizza() {
        System.out.println("Cheese pizza created");
    }
}
