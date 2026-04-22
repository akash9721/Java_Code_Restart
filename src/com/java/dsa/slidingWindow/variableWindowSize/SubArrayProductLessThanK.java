package com.java.dsa.slidingWindow.variableWindowSize;


//        Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements
//        in the subarray is strictly less than k.


//        Input: nums = [10,5,2,6], k = 100
//        Output: 8
//        Explanation: The 8 subarrays that have product less than 100 are:
//        [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
//        Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
public class SubArrayProductLessThanK {
    public static int usingBruteforce(int a[],int n,int k){
        int cnt=0;
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=i;j>=0;j--){
                product*=a[j];
                if(product<k){
                    cnt++;
                }
                else {
                    break;
                }
            }
        }
        return cnt;
    }

    public static int usingOptimal(int a[],int n,int k){
        if(k<=1)
            return 0;
        int left=0;
        int cnt=0;
        int product=1;
        for(int right=0;right<n;right++){
            product*=a[right];
            while (product>=k){
                product/=a[left];
                left++;
            }
            cnt+=right-left+1;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int a[]={10,5,2,6};
        int k=100;
        int n=a.length;

        int res = usingBruteforce(a, n, k);
        System.out.println("subarray product less than "+k+" is:- "+res);
        System.out.println();

        int res2 = usingOptimal(a, n, k);
        System.out.println("subarray product less than "+k+" is:- "+res2);
    }
}
