package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class PhonePayPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.println("processed "+amount+" via phone_pay");
    }
}
