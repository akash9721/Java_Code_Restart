package com.java.designPattern.creationalDesignPattern.singletonDesignPattern;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1==instance2);

        SingletonThreadsafe obj1 = SingletonThreadsafe.getInstance();
        SingletonThreadsafe obj2 = SingletonThreadsafe.getInstance();
        System.out.println(obj1==obj2);

        SingletonEagerInitialization eag1 = SingletonEagerInitialization.getInstance();
        SingletonEagerInitialization eag2 = SingletonEagerInitialization.getInstance();
        System.out.println(eag1==eag2);

    }
}
