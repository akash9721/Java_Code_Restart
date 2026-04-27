package com.java.dsa.slidingWindow.variableWindowSize;

public class MinimumSizeSubarraySum {

    public static int usingBruteforce(int a[],int target){
        int minSize=Integer.MAX_VALUE;
        int size=0;
        for(int i=0;i<a.length;i++){
            int sum=0;
            for(int j=i;j<a.length;j++){
                sum+=a[j];
                // Condition must be greater than or equal to
                if(sum>=target){
                    minSize=Math.min(minSize,j-i+1);
                    break; // Stop inner loop as sizes will only increase
                }
            }
        }
        return  minSize==Integer.MAX_VALUE?0:minSize;
    }
    public static int usingOptimal(int a[],int target){
        int sum=0;
        int minCount=Integer.MAX_VALUE;
        int left=0;
        int count;
        for(int right=0;right<a.length;right++){
            sum+=a[right];
            while(sum>=target){
                minCount=Math.min(minCount,right-left+1);
                sum-=a[left];
                left++;
            }
        }
        return minCount==Integer.MAX_VALUE?0:minCount;
    }
    public static void main(String[] args) {
        int a[]={2,3,1,2,4,3};
        int target=7;

        System.out.println("minimum size sub array sum is : "+usingBruteforce(a,target));
        System.out.println("minimum size sub array sum is : "+usingOptimal(a,target));
    }
}
