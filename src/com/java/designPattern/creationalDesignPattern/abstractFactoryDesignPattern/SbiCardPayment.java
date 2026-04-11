package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class SbiCardPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.println("processed "+amount+ " via sbi card");
    }
}
