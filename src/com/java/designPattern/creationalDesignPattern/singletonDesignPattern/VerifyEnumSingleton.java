package com.java.designPattern.creationalDesignPattern.singletonDesignPattern;

import java.io.*;
import java.lang.reflect.Constructor;

public class VerifyEnumSingleton {
    public static void main(String[] args) {

        SingletonUsingEnum obj1 = SingletonUsingEnum.INSTANCE;
        SingletonUsingEnum obj2 = SingletonUsingEnum.INSTANCE;

        System.out.println("== check        : " + (obj1 == obj2));                        // true
        System.out.println("hashCode check  : " + (obj1.hashCode() == obj2.hashCode())); // true
        System.out.println("equals check    : " + obj1.equals(obj2));                     // true
        System.out.println("obj1.name()     : " + obj1.name());                           // INSTANCE
        System.out.println("obj2.name()     : " + obj2.name());                           // INSTANCE

    }
}