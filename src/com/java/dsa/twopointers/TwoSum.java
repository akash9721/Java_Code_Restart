package com.java.dsa.twopointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static int[] twoSum(int arr[],int target) {
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			int sum=arr[left]+arr[right];
			if(sum==target) {
				return new int[] {left,right};
			}
			else if(sum>target) {
				right--;
			}
			else {
				left++;
			}
		}
		return new int[] {-1,-1};
	}
	
	public static int[] usingHashMap(int arr[],int target) {
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int sum=target-arr[i];
			if(map.containsKey(sum)) {
				return new int[] {i,map.get(sum)};
			}
			else {
				map.put(arr[i], i);
			}
		}
		return new int [] {};
	}
	public static void main(String[] args) {
		int numbers[] = {2,7,11,15};
		int target=9;
		int[] res = twoSum(numbers,target);
		System.out.println(res[0]+" "+res[1]);
		
		System.out.println();
		int[] res2 = usingHashMap(numbers,target);
		System.out.println(res2[0]+" "+res2[1]);

	}
}
