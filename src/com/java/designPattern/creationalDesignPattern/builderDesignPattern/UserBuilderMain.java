package com.java.designPattern.creationalDesignPattern.builderDesignPattern;

public class UserBuilderMain {
    public static void main(String[] args) {
        User basicUser = new User.UserBuilder("1", "akash@gmail.com")
                .build();
        System.out.println(basicUser);

        User fullUser = new User.UserBuilder("5", "newuser@gmail.com")
                .firstName("samay")
                .lastName("raina")
                .build();
        System.out.println(fullUser);
    }
}
