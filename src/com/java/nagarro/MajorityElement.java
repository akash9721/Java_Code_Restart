package com.java.nagarro;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map=new HashMap<>();
		
		for(int ele:nums) {
			map.put(ele, map.getOrDefault(ele,0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
			if(entry.getValue()>(nums.length)/2) {
				return entry.getKey();
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int nums[] = {2,2,1,1,1,2,2};
		
		System.out.println("Majority element is :"+majorityElement(nums));
	}
}
