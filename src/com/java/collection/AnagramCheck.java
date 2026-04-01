package com.java.collection;

import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {

	public static void main(String[] args) {
		String str1="listen";
		String str2="silent";
		
		Map<Character, Integer> map=new HashMap<>();
		
		for(char c:str1.toCharArray()) {
			map.put(c, map.getOrDefault(c,0)+1);
		}
		
		for(char c:str2.toCharArray()) {
			map.put(c, map.get(c)-1);
			if(map.get(c)==0) {
				map.remove(c);
			}
		}
		
		System.out.println(map.isEmpty());
	}
}
