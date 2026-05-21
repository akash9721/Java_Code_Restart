package com.java.java8;

public class Employee1 {
    private String name;
    private String department;
    private double salary;
    private int age;

    public Employee1(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    // Getters
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    // Clean display for console printing
    @Override
    public String toString() {
        return String.format("Employee{name='%s', dept='%s', salary=%.0f, age=%d}",
                name, department, salary, age);
    }
}
