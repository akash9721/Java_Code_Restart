package com.java.java8;

public class Employee {
	private int age;
	private String name;
	private int salary;
	private String department;
	private String gender;
	private int yearOfjoining;

	public Employee(int age, String name, int salary, String department, String gender, int yearOfjoining) {
		super();
		this.age = age;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.gender = gender;
		this.yearOfjoining = yearOfjoining;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getYearOfjoining() {
		return yearOfjoining;
	}

	public void setYearOfjoining(int yearOfjoining) {
		this.yearOfjoining = yearOfjoining;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", gender=" + gender + ", yearOfjoining=" + yearOfjoining + "]";
	}

}
