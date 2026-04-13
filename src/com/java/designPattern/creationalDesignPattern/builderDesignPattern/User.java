package com.java.designPattern.creationalDesignPattern.builderDesignPattern;

public class User {
    private final String userId;  //required
    private final String email;  //required
    private final String firstName; //optional
    private final String lastName; //optional

    private User(UserBuilder builder){
            this.userId= builder.userId;
            this.email=builder.email;
            this.firstName= builder.firstName;
            this.lastName=builder.lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class UserBuilder{
        private final String userId;
        private final String email;
        private String firstName;
        private String lastName;

        public UserBuilder(String userId,String email){
            this.userId=userId;
            this.email=email;
        }

        public UserBuilder firstName(String firstName){
            this.firstName=firstName;
            return this;
        }

        public UserBuilder lastName(String lastName){
            this.lastName=lastName;
            return this;
        }
        public User build(){
            if(this.userId==null || this.email==null){
                throw new IllegalStateException("Required fields missing");
            }
            return new User(this);
        }
    }

}
