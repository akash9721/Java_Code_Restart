package com.java.dsaString;

public class ReverseWovels {

	public static void main(String[] args) {
		String str = "abcdedilo";
		//output = "obcdidela"
		
		String reverseWovelsOutput = reverseWovels(str);
		System.out.println(reverseWovelsOutput);
	}

	private static String reverseWovels(String str) {
		char[] arr=str.toCharArray();
		int i=0;
		int j=arr.length-1;
		while(i<=j) {
			if(!(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u' )) {
				i++;
			}
			else if(!(arr[j]=='a' || arr[j]=='e' || arr[j]=='i' || arr[j]=='o' || arr[j]=='u')) {
				j--;
			}
			else {
				char temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				i++;
				j--;
			}
		}
		
		return new String(arr);
		
	}
}
