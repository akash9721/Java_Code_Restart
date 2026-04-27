package com.java.dsa.slidingWindow.variableWindowSize;

import java.util.HashMap;
import java.util.Map;

// You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array
// fruits where fruits[i] is the type of fruit the ith tree produces.
// You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
// You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
// Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
// Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
public class FruitIntoBasket {

    public static int usingBruteforce(int fruits[]){
        int cnt=0;
        int maxCount=0;
        for(int left=0;left<fruits.length;left++){
            Map<Integer,Integer> map=new HashMap<>();
            int count=0;
            for(int right=left;right<fruits.length;right++){
                map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
                if(map.size()>2){
                    break;
                }
                count++;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }

    public static int usingOptimal(int fruits[]){
        Map<Integer,Integer> map=new HashMap<>();
        int n=fruits.length;
        int maxCount=0;
        int left=0;
        for(int right=0;right<n;right++){
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            maxCount=Math.max(maxCount,right-left+1);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int []fruits = {1,2,3,2,2};
        System.out.println("maximum subarray with atmost 2 element is : "+usingBruteforce(fruits));
        System.out.println();
        System.out.println("maximum subarray with atmost 2 element is : "+usingOptimal(fruits));
    }
}
