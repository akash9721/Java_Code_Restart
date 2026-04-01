package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class EvenOddPrint{
	
	private int count=1;
	private final int max=20;
	
	private  final ReentrantLock lock=new ReentrantLock();
	private  final Condition evenCondition=lock.newCondition();
	private  final Condition oddCondition=lock.newCondition();
	
	public void printOdd(){
		while(true) {
			lock.lock();
			try {
				while(count<=max && count%2==0) {
					oddCondition.await();
				}
				if(count>max) {
					evenCondition.signal();
					break;
				}
				System.out.println(Thread.currentThread().getName()+" "+count++);
				evenCondition.signal();
				
			}
			catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			finally {
				lock.unlock();
			}
		}
	}
	
	public void evenPrint() {
		while(true) {
			lock.lock();
			try {
				while(count<=max && count%2!=0) {
					evenCondition.await();
				}
				
				if(count>max) {
					oddCondition.signal();
					break;
				}
				
				System.out.println(Thread.currentThread().getName()+" "+count++);
				oddCondition.signal();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			finally {
				lock.unlock();
			}
		}
	}
}
public class PrintEvenOddUsingExecutor {
	public static void main(String[] args) {
		
		EvenOddPrint print=new EvenOddPrint();
		
		ExecutorService executor=Executors.newFixedThreadPool(2);
		executor.submit(print::printOdd);
		executor.submit(print::evenPrint);
		
		executor.shutdown();
	}
}
