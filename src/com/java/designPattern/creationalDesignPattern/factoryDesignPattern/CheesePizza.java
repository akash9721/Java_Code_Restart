package com.java.designPattern.creationalDesignPattern.factoryDesignPattern;

public class CheesePizza implements Pizza{
    @Override
    public void makePizza() {
        System.out.println("Cheese pizza created");
    }
}
