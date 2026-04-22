package com.java.dsa.twopointers;

public class MoveAllZero {

	public static void move(int a[]) {
		int j=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=0) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				j++;
			}
		}
		for(int arr:a) {
			System.out.print(arr+" ");
		}
	}
	
	public static void print100(int n) {
		if(n>100) {
			return;
		}
		System.out.print(n+" ");
		print100(n+1);
	}
	public static void main(String[] args) {
		int arr[]= {0,1,0,3,0,5};
		
		move(arr);
		System.out.println();
		print100(1);
		
	}
}
