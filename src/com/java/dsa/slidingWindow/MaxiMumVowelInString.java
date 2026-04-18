package com.java.dsa.slidingWindow;

public class MaxiMumVowelInString {

    public static int check(String input,int k){
        int n=input.length();
        int count=0;
        int maxCount=0;
        for(int i=0;i<k;i++){
            char ch=input.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ){
                count++;
            }

        }
        maxCount=count;
        for(int i=k;i<n;i++){
            if(input.charAt(i-k)=='a' || input.charAt(i-k)=='e' || input.charAt(i-k)=='i' || input.charAt(i-k)=='o' || input.charAt(i-k)=='u' ){
                count--;
            }
            if(input.charAt(i)=='a' || input.charAt(i)=='e' || input.charAt(i)=='i' || input.charAt(i)=='o' || input.charAt(i)=='u' ){
                count++;
            }
            maxCount=Math.max(count,maxCount);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        String input="aeiou";
        int k=2;

        int maxVowel = check(input, k);
        System.out.println("maximum vowel in given "+k+" size is "+maxVowel);
    }
}
