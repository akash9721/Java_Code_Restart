package com.java.nagarro;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyCount {

	public static String frequency(String input) {
		Map<Character, Integer> map=new LinkedHashMap<>();
		String result="";
		char[] arr=input.toCharArray();
		Arrays.sort(arr);		
		for(char ch:arr) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
	
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			result+=""+entry.getKey()+entry.getValue();
		}
		
		return result;
	}
	
	public static String usingFrequencyArray(String input) {
		int[] freq = new int[256]; 
	    StringBuilder result = new StringBuilder();

	    // Increment count at the index of the character's ASCII value
	    for (char ch : input.toCharArray()) {
	        freq[ch]++;
	    }

	    // Iterate through the ASCII range
	    for (int i = 0; i < 256; i++) {
	        if (freq[i] > 0) {
	            result.append((char) i).append(freq[i]);
	        }
	    }
	    return result.toString();
	}
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a string");
		String input=scanner.nextLine();
		
		System.out.println(frequency(input));
		System.out.println();
		System.out.println(usingFrequencyArray(input));
		
	}
}
