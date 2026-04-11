package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class UpiPaymentFactory implements PaymentFactory{
    @Override
    public Payment createPayment(PaymentProvider provider) {
        return switch (provider){
            case GOOGLE -> new GooglePayPayment();
            case PHONE -> new PhonePayPayment();
            default -> throw new IllegalArgumentException("Unknown upi provider");
        };
    }
}
