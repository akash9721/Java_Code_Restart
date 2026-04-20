package com.java.dsa.slidingWindow.variableWindowSize;

class FindMaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
                max=Math.max(cnt,max);
            }
            else{
                cnt=0;
                max=Math.max(cnt,max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int nums[]={1,1,0,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println("maximum consuecutive one is :"+maxConsecutiveOnes);
    }
}