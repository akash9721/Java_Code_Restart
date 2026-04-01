package com.java.dsa.twopointers;

public class ValidPalindrom {

	public static boolean check(String str) {
		int i=0;
		int j=str.length()-1;
		while(i<j) {
			char start=str.charAt(i);
			char end=str.charAt(j);
			
			if(!Character.isLetterOrDigit(start)) {
				i++;
			}
			
			else if(!Character.isLetterOrDigit(end)) {
				j--;
			}
			
			else {
				if(Character.toLowerCase(start)!=Character.toLowerCase(end)) {
					return false;
				}
				i++;
				j--;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		
		System.out.println(check(s));
	}
}
