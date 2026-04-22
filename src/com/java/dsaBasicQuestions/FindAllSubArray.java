package com.java.dsaBasicQuestions;

public class FindAllSubArray {
    public static void allSubarrays(int a[]){
        for(int i=0;i<a.length;i++){
            String output="";
            for(int j=i;j<a.length;j++){
                output+=a[j]+" ";
                System.out.println(output);
            }
        }
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        allSubarrays(a);
    }
}
