package com.java.dsa.slidingWindow.variableWindowSize;

// Given a binary array nums and an integer k, return the maximum number of consecutive 1's
// in the array if you can flip at most k 0's.
public class MaiximumConscutiveOne111 {

    public static int longestOnesBruteForce(int a[],int k){
        int n=a.length;
        int maxOne=0;
        for(int i=0;i<n;i++){
            int zero=0;
            for(int j=i;j<n;j++){
                if(a[j]==0) {
                    zero++;
                }
                if (zero<=k){
                    maxOne=Math.max(maxOne,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxOne;
    }

    public static int longestOnesOptimal(int a[],int k){
        int n=a.length;
        int zeroCount=0;
        int start=0;
        int maxOne=0;
        for(int end=0;end<n;end++){
            if(a[end]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(a[start]==0){
                    zeroCount--;
                }
                start++;
            }
            maxOne=Math.max(maxOne,end-start+1);
        }
        return maxOne;
    }
    public static void main(String[] args) {
        int a[]={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        System.out.println("maximum consecutive 1 after flipping "+k+" zero is: "+longestOnesBruteForce(a,k));

        System.out.println("maximum consecutive 1 after flipping "+k+" zero is: "+longestOnesOptimal(a,k));
    }
}
