package com.java.nagarro;

import java.util.Scanner;

public class ModifyVariable {

	public static String modify(String input) {
		StringBuilder result=new StringBuilder();
		if(input.contains("_")) {
			boolean capitalizeNext =false;
			for(char ch:input.toCharArray()) {
				if(ch=='_') {
					capitalizeNext=true;
				}
				else {
					if (capitalizeNext) {
						result.append(Character.toUpperCase(ch));
						capitalizeNext=false;
					}
					else {
						result.append(ch);
					}
				}
			}
		}
		else {
			for(char ch:input.toCharArray()) {
				if(Character.isUpperCase(ch)) {
					result.append("_").append(Character.toLowerCase(ch));
				}
				else {
					result.append(ch);
				}
			}
		}
		
		return result.toString();
	}
	public static void main(String[] args) {
//		Input
//		2
//		15
//		thisIsAVariable
//		18
//		this_is_a_variable
//		Output0
//		this_is_a_variable
//		thisIsAVariable
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of test cases:");
		int n = sc.nextInt();

		// FIX: Consume the leftover newline character
		sc.nextLine(); 

		for (int i = 0; i < n; i++) {
		    System.out.println("Enter String for test case " + (i + 1) + ":");
		    String input = sc.nextLine(); // Now this will wait for your input
		    System.out.println(modify(input));
		}
		
	}
}
