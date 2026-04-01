package com.java.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReenternceTryLock {
	private static final ReentrantLock lock=new ReentrantLock();
	
	public static void doWork() {
		try {
			if(lock.tryLock(2,TimeUnit.SECONDS)) {
				try {
					System.out.println(Thread.currentThread().getName()+" acquiring the lock");
					Thread.sleep(3000);
				} catch (Exception e) {
					Thread.currentThread().interrupt();
				}
				finally {
					lock.unlock();
					System.out.println(Thread.currentThread().getName()+" Release the lock");
				}
			}
			else {
				System.out.println(Thread.currentThread().getName()+" not acquire lock");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Thread t1=new Thread(()->doWork());
		Thread t2=new Thread(()->doWork());
		
		t1.start();
		t2.start();
	}
}
