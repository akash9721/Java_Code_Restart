package com.java.designPattern.creationalDesignPattern.singletonDesignPattern;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WayToBreakSingletonDesign {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, CloneNotSupportedException {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1==instance2);

        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("\nUsing reflection Api");
        Class<?> aClass = Class.forName("com.java.designPattern.creationalDesignPattern.singletonDesignPattern.Singleton");
        Constructor<Singleton> constructor = (Constructor<Singleton>) aClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton reflectionObject = constructor.newInstance();
        System.out.println(instance1==reflectionObject);

        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("\nUsing deserialization");
        FileOutputStream fos=new FileOutputStream(new File("singleton.txt"));
        ObjectOutputStream oos =new ObjectOutputStream(fos);
        oos.writeObject(instance1);
        oos.close();
        System.out.println("object serialized");

        FileInputStream fis=new FileInputStream("singleton.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Singleton deserializedObject = (Singleton) ois.readObject();
        System.out.println(instance1==deserializedObject);

        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("\nUsing clone");
        Singleton clonedObject = (Singleton) instance1.clone();
        System.out.println(instance1==clonedObject);


    }
}
