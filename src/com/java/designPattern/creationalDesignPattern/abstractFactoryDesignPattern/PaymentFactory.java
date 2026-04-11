package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public interface PaymentFactory {
    Payment createPayment(PaymentProvider provider);
}
