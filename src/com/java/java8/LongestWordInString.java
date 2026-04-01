package com.java.java8;

import java.util.Arrays;

public class LongestWordInString {

	public static void main(String[] args) {
		String str = "java stream api is powerful";
		
		String lw = Arrays.stream(str.trim().split("\\s+"))
				.reduce((w1,w2)->w1.length()>w2.length()?w1:w2).get();
		System.out.println(lw);
	}
}
