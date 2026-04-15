package com.java.dsa.slidingWindow;

public class MaxSubarraySumOfSizeK {
    public static int usingBruteforce(int arr[],int k){

        int maxSum=Integer.MIN_VALUE;
        int n=arr.length;
        for(int i=0;i<=n-k;i++){
            int currSum=0;
            for(int j=i;j<k+i;j++){
                currSum+=arr[j];
            }
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }

    public static int usingOptimize(int arr[],int k){
        int n=arr.length;
        int currSum=0;
        int maxSum=0;
        for(int i=0;i<k;i++){
            currSum+=arr[i];
        }

        maxSum=currSum;
        for(int i=k;i<n;i++){
            currSum+=arr[i]-arr[i-k];
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[]={100,200,300,400,500};
        int k=2;
        System.out.println("maximum subarray sum of size "+k);
        int maxsumofsizek_1 = usingBruteforce(arr, k);
        System.out.println(maxsumofsizek_1);

        int maxsumofsizek_2 = usingOptimize(arr, k);
        System.out.println(maxsumofsizek_2);


    }
}
