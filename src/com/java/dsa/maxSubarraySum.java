package com.java.dsa;

public class maxSubarraySum {

    public static int maxSum(int[] arr) {
        // Code here
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }
    
    public static  int maxSubarraySum(int[] arr) {
        // Code here
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            currSum=Math.max(currSum+arr[i],arr[i]);
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }
	public static void main(String[] args) {
		int arr[] = {2, 3, -8, 7, -1, 2, 3};
		
		System.out.println(maxSum(arr));
		System.out.println();
		System.out.println(maxSubarraySum(arr));
	}
}
