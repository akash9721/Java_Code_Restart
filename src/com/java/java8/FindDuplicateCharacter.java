package com.java.java8;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class FindDuplicateCharacter {
	public static void main(String[] args) {
		String str = "programming";
		str.chars()
			.mapToObj(ch->(char)ch)
				.collect(Collectors.groupingBy(ch->ch,LinkedHashMap::new,Collectors.counting()))
					.entrySet()
						.stream()
							.filter(e->e.getValue()>1)
								.forEach(e->System.out.println(e.getKey()+" "+e.getValue()));
	}
}
