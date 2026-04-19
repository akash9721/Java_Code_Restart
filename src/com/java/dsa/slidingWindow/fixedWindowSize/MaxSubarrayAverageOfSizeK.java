package com.java.dsa.slidingWindow.fixedWindowSize;

public class MaxSubarrayAverageOfSizeK {
    public static double usingBruteforce(int arr[],int k){

        double maxSum=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<=n-k;i++){
            double currSum=0;
            for(int j=i;j<k+i;j++){
                currSum+=arr[j];
            }
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum/k;
    }

    public static double usingOptimize(int arr[],int k){
        int n=arr.length;
        double currSum=0;
        double maxSum=0;
        for(int i=0;i<k;i++){
            currSum+=arr[i];
        }

        maxSum=currSum;
        for(int i=k;i<n;i++){
            currSum+=arr[i]-arr[i-k];
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum/k;
    }
    public static void main(String[] args) {
        int arr[]={1,12,-5,-6,50,3};
        int k=4;
        System.out.println("maximum subarray sum of size "+k);
        double maxavgofsizek_1 = usingBruteforce(arr, k);
        System.out.println(maxavgofsizek_1);

        double maxavgofsizek_2 = usingOptimize(arr, k);
        System.out.println(maxavgofsizek_2);


    }
}
