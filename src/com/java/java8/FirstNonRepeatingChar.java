package com.java.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		String Str="specpsesi";
		
		Map<Character, Integer> fnrc=new LinkedHashMap<>();
		
		for(char ch:Str.toCharArray()) {
			fnrc.put(ch, fnrc.getOrDefault(ch,0)+1);
		}
		
		for(Map.Entry<Character, Integer> entry:fnrc.entrySet()) {
			if(entry.getValue()==1) {
				System.out.println(entry.getKey());
				break;
			}
		}
		
		System.out.println("using java 8");
		Character fnrcis = Str.chars()
			.mapToObj(ch->(char)ch)
				.collect(Collectors.groupingBy(ch->ch,LinkedHashMap::new,Collectors.counting()))
					.entrySet()
						.stream()
							.filter(e->e.getValue()==1)
								.map(Map.Entry::getKey)
									.findFirst()
										.orElse(null);
		System.out.println(fnrcis);
		
	}
}
