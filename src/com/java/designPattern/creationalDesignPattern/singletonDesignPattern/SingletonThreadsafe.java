package com.java.designPattern.creationalDesignPattern.singletonDesignPattern;

public class SingletonThreadsafe {

    private static SingletonThreadsafe instance;

    private SingletonThreadsafe(){
        System.out.println("\nThreadsafe singleton object");
    }

//    public static synchronized SingletonThreadsafe getInstance(){
//        if(instance==null){
//            instance=new SingletonThreadsafe();
//        }
//        return instance;
//    }

    public static SingletonThreadsafe getInstance(){
        if(instance==null){
           synchronized (SingletonThreadsafe.class){
               if(instance==null){
                   instance=new SingletonThreadsafe();
               }
           }
        }
        return instance;
    }
}
