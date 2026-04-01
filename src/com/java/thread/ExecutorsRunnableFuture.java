package com.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//find sum

class Sum implements Callable<Integer>{

	int n;
	public Sum(int val) {
		n=val;
	}
	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		return sum;
	}
	
}
//find square

class Square implements Callable<Double>{

	int num;
	public Square(int val) {
		num=val;
	}
	
	@Override
	public Double call() throws Exception {
		return Math.sqrt(num);
	}
	
}

//find factorial
class Factorial implements Callable<Integer>{

	int n;
	public Factorial(int val) {
		n=val;
	}
	int fact=1;
	@Override
	public Integer call() throws Exception {
		for(int i=1;i<=n;i++) {
			fact*=i;
		}
		return fact;
	}
	
}
public class ExecutorsRunnableFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exe=Executors.newFixedThreadPool(3);
		Future<Integer> sum = exe.submit(new Sum(10));
		Future<Double> square = exe.submit(new Square(16));
		Future<Integer> factorial = exe.submit(new Factorial(5));
		
		System.out.println(sum.get());
		System.out.println(square.get());
		System.out.println(factorial.get());
		
		exe.shutdown();
		
		System.out.println("completed");
		
		
	}
}
