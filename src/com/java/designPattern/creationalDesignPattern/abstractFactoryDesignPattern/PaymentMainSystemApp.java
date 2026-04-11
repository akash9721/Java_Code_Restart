package com.java.designPattern.creationalDesignPattern.abstractFactoryDesignPattern;

public class PaymentMainSystemApp {
    public static void main(String[] args) {
        PaymentFactory cardPayment = FactoryProducer.getFactory(PaymentCategory.CARD);
        Payment sbiPayment = cardPayment.createPayment(PaymentProvider.SBI);
        sbiPayment.processPayment(5000);

        PaymentFactory upiPayment = FactoryProducer.getFactory(PaymentCategory.UPI);
        Payment phonePayPayment = upiPayment.createPayment(PaymentProvider.PHONE);
        phonePayPayment.processPayment(10000);

        PaymentFactory netBankingPayment = FactoryProducer.getFactory(PaymentCategory.NET_BANKING);
        Payment hdfcPayment = netBankingPayment.createPayment(PaymentProvider.HDFC);
        hdfcPayment.processPayment(250000);

    }
}
