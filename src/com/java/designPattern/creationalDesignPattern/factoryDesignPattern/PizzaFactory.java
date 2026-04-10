package com.java.designPattern.creationalDesignPattern.singletonDesignPattern.factoryDesignPattern;

public class PizzaFactory {

    public static Pizza pizzaType(String type){
        if(type==null || type.isEmpty())
            return null;
        return switch(type.toLowerCase()){
            case "veg" -> new VegPizza();
            case "chicken" -> new ChickenPizza();
            case "cheese" -> new CheesePizza();
            default -> null;
        };
    }
}
