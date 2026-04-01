package com.java.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReenteranceLockExample {
	
		 private static int counter=1;
		 
		 private static final ReentrantLock lock=new ReentrantLock();
		 
		 public static void getIncrement() {
			 lock.lock();
			 try {
				 for(int i=1;i<=5;i++) {
					 System.out.println(Thread.currentThread().getName()+" :"+ counter++);
				 }
			} finally {
				 lock.unlock();
			}
			 
		 }
		 
	public static void main(String[] args) {
		
		Thread th1=new Thread(()->getIncrement());
		th1.start();
		
		Thread th2=new Thread(()->getIncrement());
		th2.start();
		
	}
}
