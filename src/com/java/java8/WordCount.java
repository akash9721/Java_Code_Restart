package com.java.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {
			 
	public static void main(String[] args) {
		String words="java is java and java is beautiful";
		Map<String, Integer> map=new HashMap<>();
		for(String word:words.split(" ")) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		System.out.println(map);
		System.out.println();
		map.forEach((k,v)->System.out.println(k+" -> "+v));
		
		System.out.println("\n using java 8");
		Arrays.stream(words.split(" "))
				.collect(Collectors.groupingBy(x->x,Collectors.counting()))
					.forEach((k,v)->System.out.println(k+" -> "+v));
	}
}
