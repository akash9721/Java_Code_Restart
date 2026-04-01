package com.java.dsa;

import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveDuplicateCharacter {

	public static void main(String[] args) {
		String str = "programming";
			str.chars().mapToObj(ch->(char)ch).distinct().forEach(s->System.out.print(s));
			
			
			System.out.println();
			Map<Character, Integer> map=new LinkedHashMap<>();
			for(char ch:str.toCharArray()) {
				map.put(ch, map.getOrDefault(ch, 0)+1);
			}
			
			for(Map.Entry<Character, Integer> entry:map.entrySet()) {
				System.out.print(entry.getKey());
			}
	}
}
