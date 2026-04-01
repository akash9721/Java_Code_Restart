package com.java.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountFreq {
	public static void main(String[] args) {
		String str1="banana";
		
		Map<Character, Integer> map=new HashMap<>();
		for(char ch:str1.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		map.forEach((k,v)->System.out.println(k+" "+v));
		
		System.out.println("+++++++++++++++++++++++++++");
		
		str1.chars()
			.mapToObj(ch->(char)ch)
				.collect(Collectors.groupingBy(ch->ch,Collectors.counting()))
					.forEach((k,v)->System.out.println(k+" "+v));
		
		System.out.println("+++++++++++++++++++++++++++++");
		str1.chars()
			.mapToObj(ch->(char)ch)
				.collect(Collectors.groupingBy(ch->ch,LinkedHashMap::new,Collectors.counting()))
					.forEach((k,v)->System.out.println(k+" "+v));
	}
}
