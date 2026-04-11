package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class CardPaymentFactory implements PaymentFactory{
    @Override
    public Payment createPayment(PaymentProvider provider) {
        return switch (provider){
            case SBI -> new SbiCardPayment();
            case AXIS -> new AxisCardPayment();
            default -> throw new IllegalArgumentException("Unknown card payment");
        };
    }
}
