package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class GooglePayPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.println("processed "+amount+ " via google_pay");
    }
}
