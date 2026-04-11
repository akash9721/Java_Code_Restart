package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class FactoryProducer {
    public static PaymentFactory getFactory(PaymentCategory category){
        return switch (category){
            case UPI -> new UpiPaymentFactory();
            case CARD -> new CardPaymentFactory();
            case NET_BANKING -> new NetBankingFactory();
            default -> throw new IllegalArgumentException("Unknown payment category added");
        };
    }
}
