package com.java.dsa.twopointers;

public class ContainerWithMostWater {
 
	public static int maxArea(int a[]) {
		int maxRes=0;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				int width=j-i;
				int hight=Math.min(a[j], a[i]);
				int currWter=width*hight;
				maxRes=Math.max(maxRes, currWter);
			}
		}
		return maxRes;
	}
	
	public static int optimalMaxRes(int a[]) {
		int maxWater=0;
		int start=0;
		int end=a.length-1;
		
		while(start<end) {
			int width=end-start;
			int hight=Math.min(a[end], a[start]);
			int currWater=width*hight;
			maxWater=Math.max(maxWater, currWater);
			if(a[start]<a[end]) {
				start++;
			}
			else {
				end--;
			}
		}
		return maxWater;
	}
	public static void main(String[] args) {
		int height[]= {1,8,6,2,5,4,8,3,7};
		
		System.out.println("maximum water "+maxArea(height));
		System.out.println();
		
		System.out.println(optimalMaxRes(height));
	}
}
