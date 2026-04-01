package com.java.thread;

import java.util.Map;

public class ConcurrentHashMap {

	public static void main(String[] args) {
		
		Map<String, Integer> map=new  java.util.concurrent.ConcurrentHashMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		
		Thread readThread=new Thread(()->{
			
			for(String key:map.keySet()) {
				System.out.println("Key: "+ key+ ", Value: "+map.get(key));
			}
		});
		
		readThread.start();
		
		Thread writeThread=new Thread(()->{
			
			map.put("Five", 5);
		});
		writeThread.start();
	}
}
