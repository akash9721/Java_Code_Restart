package com.java.thread;

class Test extends Thread{
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}

class Test2 implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId()+" using runnable interface");
	}
	
}
public class ThreadCreation {
		public static void main(String[] args) throws InterruptedException {
			System.out.println("thread creation using thread class");
			Test th=new Test();
			th.start();
			System.out.println(Thread.currentThread().getName());
			
			Thread.sleep(5);
			System.out.println("\nthread creation using runnable interface");
			Thread th2=new Thread(new Test());
			th2.start();
		}
}
