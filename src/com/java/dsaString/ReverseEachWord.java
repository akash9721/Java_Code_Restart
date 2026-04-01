package com.java.dsaString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseEachWord {
	
	private static void method1(String str) {
		StringBuilder result=new StringBuilder();
		String[] words = str.split(" ");
		for(String w:words) {
			StringBuilder sb=new StringBuilder(w);
			result.append(sb.reverse()).append(" ");
		}
		
		System.out.println(result.toString().trim());
		
	}
	
	public static void method2(String str) {
		StringBuilder res=new StringBuilder();
		int start=0;
		for(int i=0;i<=str.length();i++) {
			if(i==str.length() || str.charAt(i)==' ') {
				for(int j=i-1;j>=start;j--) {
					res.append(str.charAt(j));
				}
				res.append(" ");
				start=i+1;
			}
		}
		
		System.out.println(res.toString().trim());
	}
	
	public static void method3(String str) {
		String reverseWords = Arrays.stream(str.split(" "))
				.map(word->new StringBuilder(word).reverse().toString())
					.collect(Collectors.joining(" "));
		System.out.println(reverseWords);
	}
	
	public static void main(String[] args) {
		String str="the coding monk";
		
		System.out.println("using first approach");
		method1(str);
		
		System.out.println("using second approach");
		method2(str);
		
		System.out.println("using third approach");
		method3(str);
		
		List<Integer> list = Arrays.asList(1,3,2,4,3,1,2);
		list.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
