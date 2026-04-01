package com.java.slowFastPtr;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static int happyNumber(int n) {
		int sum=0;
		int num=n;
		int res;
		while(num!=0) {
			res=num%10;
			sum+=res*res;
			num=num/10;
		}
		return sum;
	}
	
	public static boolean isHappy(int n) {
		Set<Integer> seen=new HashSet<>();
		while(n!=1 && !seen.contains(n)) {
			seen.add(n);
			n=happyNumber(n);
		}
		
		return n==1;
	}
	
	public static boolean isHappy1(int n) {
		int slow=n;
		int fast=n;
		do {
			slow=happyNumber(slow);
			fast=happyNumber(happyNumber(fast));
		}while(slow!=fast);
		
		return slow==1;
	}
	
	public static void main(String[] args) {
		int n=19;
		System.out.println(isHappy1(n)?n+" is happy No":n+" is not happy no");
		System.out.println();
		System.out.println(isHappy(n)?n+" is happy No":n+" is not happy no");
	}
}
