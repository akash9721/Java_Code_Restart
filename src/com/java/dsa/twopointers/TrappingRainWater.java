package com.java.dsa.twopointers;

public class TrappingRainWater {

	public static int usingExtraSpace(int arr[]) {
		int ans=0;
		int n=arr.length;
		int leftmax[]=new int [n];
		int rightmax[]=new int [n];
		leftmax[0]=arr[0];
		rightmax[n-1]=arr[n-1];
		
		for(int i=1;i<n;i++) {
			leftmax[i]=Math.max(leftmax[i-1], arr[i]);
		}
		
		for(int i=n-2;i>=0;i--) {
			rightmax[i]=Math.max(rightmax[i+1], arr[i]);
		}
		
		for(int i=0;i<n;i++) {
			ans+=Math.min(leftmax[i], rightmax[i])-arr[i];
		}
		return ans;
	}
	
	public static int usingTwoPonter(int arr[]) {
		int n=arr.length;
		int ans=0;
		int leftMax=0;
		int rightMax=0;
		int l=0;
		int r=n-1;
		while(l<r) {
			leftMax=Math.max(leftMax, arr[l]);
			rightMax=Math.max(rightMax, arr[r]);
			
			if(leftMax<rightMax) {
				ans+=leftMax-arr[l];
				l++;
			}
			else {
				ans+=rightMax-arr[r];
				r--;
			}
			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		int arr[]= {0,1,0,2,1,0,1,3,2,1,2,1};
				
		System.out.println("max water contains: "+usingExtraSpace(arr));
		System.out.println();
		System.out.println("max water contains: "+usingTwoPonter(arr));
	}
}
