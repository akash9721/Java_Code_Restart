package com.java.dsa.stack;

import java.util.Stack;

public class BalanceParanthesis {

	public static boolean validParanthesis(String str) {
		Stack<Character> stack=new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='{' || str.charAt(i)=='[' || str.charAt(i)=='(') {
				stack.push(str.charAt(i));
			}
			else {
				if((!stack.isEmpty()) && 
				  (str.charAt(i)=='}' && stack.peek()=='{') || 
				  (str.charAt(i)==')' && stack.peek()=='(') || 
				  (str.charAt(i)==']' && stack.peek()=='[')) {
					stack.pop();
				}
				else {
					return false;
				}
			}
		}
		
		return stack.empty();
		
	}
	public static void main(String[] args) {
		String paranthesis="()[]{}";
		
		System.out.println(validParanthesis(paranthesis));
	}
}
