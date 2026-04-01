package com.java.dsa.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class LargestZeroSumSubarray {

	public static int largestZeroSubarraySum(int a[]) {
		
		Map<Integer, Integer> map=new HashMap<>();
		int sum=0;
		int maxLen=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
			
			if(sum==0) {
				maxLen=i+1;
			}
			
			if(map.containsKey(sum)) {
				maxLen=Math.max(maxLen,i- map.get(sum));
			}
			else {
				map.put(sum, i);
			}
		}
		
		return maxLen;
	}
	public static void main(String[] args) {
		int[] arr = {1, 2, -3, 3, -1, -2, 4};
		
		int maxLen = largestZeroSubarraySum(arr);
		System.out.println("maximum largest zero sub array sum is: "+maxLen);
	}
}
