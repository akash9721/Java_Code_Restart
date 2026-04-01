package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Task1 implements Runnable{
	private static final ReentrantLock lock=new ReentrantLock();
	
	@Override
	public void run() {
		lock.lock();
		try {
			for(int i=0;i<=5;i++) {
				System.out.println(Thread.currentThread().getName()+" "+i);
			}
		}
		finally {
			lock.unlock();
		}
		
	}
	
}
public class ReentrantLockDemo {
	public static void main(String[] args) {
		
//		Thread th1=new Thread(new Task1());
//		th1.start();
//		
//		Thread th2=new Thread(new Task1());
//		th2.start();
		
		ExecutorService executor=Executors.newFixedThreadPool(2);
		executor.execute(new Task1());
		executor.execute(new Task1());
	}
}
