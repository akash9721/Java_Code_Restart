package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class AxisCardPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.println("processed "+amount+ " via axis card");
    }
}
