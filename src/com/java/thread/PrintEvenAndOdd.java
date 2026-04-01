package com.java.thread;

class Printer implements Runnable{

	static int count=1;
	int reminder;
	static Object lock=new Object();
	
	public Printer(int reminder) {
		this.reminder=reminder;
	}
	
	public void print() {
		System.out.println(Thread.currentThread().getName()+" "+count++);
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			synchronized (lock) {
				while(count%2!=reminder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				print();
				lock.notifyAll();
			}
		}
	}
	
}
public class PrintEvenAndOdd {

	public static void main(String[] args) {
		Thread even=new Thread(new Printer(0),"Even Thread");
		Thread odd=new Thread(new Printer(1),"Odd Thread");
		
		even.start();
		odd.start();
	}
}
