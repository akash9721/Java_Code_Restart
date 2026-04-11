package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class HdfcNetBankingPayment implements Payment{
    @Override
    public void processPayment(double amount) {
        System.out.println("processed "+amount+" via hdfc net banking");
    }
}
