package com.java.dsaString;

import java.util.Arrays;

public class CheckAnagram {

	public static boolean checkAnagram(String str1,String str2) {
		if(str1.length()!=str2.length())
			return false;
		int arr[]=new int[26];
		for(int i=0;i<str1.length();i++) {
			arr[str1.charAt(i)-'a']++;
			arr[str2.charAt(i)-'a']--;
		}
		
		for(int ele:arr) {
			if(ele>0)
				return false;
		}
		return true;
	}
	
	public static boolean checkAnagram2(String str1,String str2) {
		if(str1.length()!=str2.length())
			return false;
		char[] arr1=str1.toCharArray();
		char[] arr2=str2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}
	public static void main(String[] args) {
		
		String str1="listen";
		String str2="silent";
		
		boolean check1 = checkAnagram(str1,str2);
		System.out.println(check1);
		
		System.out.println(checkAnagram2(str1, str2));
	}
}
