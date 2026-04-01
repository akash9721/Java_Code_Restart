package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable{
	private String taskName;
	
	public Task(String taskName) {
		this.taskName=taskName;
	}
	
	public void run() {
		System.out.println(taskName+ " exected by "+ Thread.currentThread().getName());
	}
}
public class ExecutorExample {
	
	public static void main(String[] args) {
//		Task t1=new Task("task1");
//		Task t2=new Task("task2");
//		Task t3=new Task("task3");
//		
//		Thread th1=new Thread(t1);
//		Thread th2=new Thread(t2);
//		Thread th3=new Thread(t3);
//		
//		th1.start();
//		th2.start();
//		th3.start();
		
		ExecutorService exe=Executors.newFixedThreadPool(3);
		exe.execute(new Task("task1"));
		exe.execute(new Task("task2"));
		exe.execute(new Task("task3"));
		
		exe.shutdown();
	}
}
