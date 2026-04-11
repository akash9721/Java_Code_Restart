package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class NetBankingFactory implements PaymentFactory{
    @Override
    public Payment createPayment(PaymentProvider provider) {
        return switch (provider){
            case HDFC -> new HdfcNetBankingPayment();
            default -> throw new IllegalArgumentException("Unknown net banking provided");
        };
    }
}
