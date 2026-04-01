package com.java.dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static int longestSubstringWithoutRepeating(String str) {
		int maxLen=0;
		int left=0;
		
		Map<Character, Integer> map=new HashMap<>();
		for(int right=0;right<str.length();right++) {
			char currChar=str.charAt(right);
			if(map.containsKey(currChar)) {
				left=Math.max(left, map.get(currChar)+1);
			}
			map.put(currChar, right);
			maxLen=Math.max(maxLen, right-left+1);
		}
		
		return maxLen;
		
	}
	public static void main(String[] args) {
		String str="pwwkewxpw";
		
		System.out.println("maximum substring length without repeting character: "+longestSubstringWithoutRepeating(str));
	}
}
