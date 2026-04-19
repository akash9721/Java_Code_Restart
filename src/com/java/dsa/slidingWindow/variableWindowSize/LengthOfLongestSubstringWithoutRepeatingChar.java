package com.java.dsa.slidingWindow.variableWindowSize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstringWithoutRepeatingChar {
    public static int usingBruteforce(String str){
        int n=str.length();
        int res=0;
        for(int i=0;i<n;i++){
            Set<Character> seen=new HashSet<>();
            for(int j=i;j<n;j++){
                if(seen.contains(str.charAt(j))){
                    break;
                }
                seen.add(str.charAt(j));
                res=Math.max(res,j-i+1);
            }
        }
        return res;
    }

    public static int longestSubstringWithoutRepeating(String str) {
        int maxLen=0;
        int left=0;

        Map<Character, Integer> map=new HashMap<>();
        for(int right=0;right<str.length();right++) {
            char currChar=str.charAt(right);
            if(map.containsKey(currChar)) {
                left=Math.max(left, map.get(currChar)+1);
            }
            map.put(currChar, right);
            maxLen=Math.max(maxLen, right-left+1);
        }

        return maxLen;

    }
    public static int usingOptimal(String str){
        Set<Character> seen=new HashSet<>();
        int n=str.length();
        int left=0;
        int res=0;
        for(int right = 0; right<n; right++){
            while (seen.contains(str.charAt(right))){
                seen.remove(str.charAt(left));
                left++;
            }
            seen.add(str.charAt(right));
            res=Math.max(res,right-left+1);
        }
        return res;
    }
    public static void main(String[] args) {
        String str="thisisalongx";
        System.out.println("length of longest string without repeating character "+usingBruteforce(str));
        System.out.println("maximum substring length without repeting character: "+longestSubstringWithoutRepeating(str));
        System.out.println("length of longest string without repeating character "+usingOptimal(str));
    }
}
