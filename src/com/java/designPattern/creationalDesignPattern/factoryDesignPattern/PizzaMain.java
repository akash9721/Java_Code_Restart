package com.java.designPattern.creationalDesignPattern.singletonDesignPattern.factoryDesignPattern;

public class PizzaMain {
    public static void main(String[] args) {
        Pizza veg = PizzaFactory.pizzaType("veg");
        veg.makePizza();

        Pizza cheese = PizzaFactory.pizzaType("cheese");
        cheese.makePizza();
    }
}
