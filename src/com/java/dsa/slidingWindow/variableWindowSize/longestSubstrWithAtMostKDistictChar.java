package com.java.dsa.slidingWindow.variableWindowSize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestSubstrWithAtMostKDistictChar {
    public static int usingOptimal(String str,int k){
        Map<Character,Integer> map=new HashMap<>();
        int res=0;
        int left=0;
        for(int right=0;right<str.length();right++){
            char currChar=str.charAt(right);
            map.put(currChar,map.getOrDefault(currChar,0)+1);

            while (map.size()>k){
                char leftChar=str.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }
            res=Math.max(res,right-left+1);

        }
        return res;
    }
    public static void main(String[] args) {
        String str="thisisalongx";
        int k=4;

        System.out.println("longest substring with atmost "+k+" distinct char is "+usingOptimal(str,k));
    }
}
