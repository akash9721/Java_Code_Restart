package com.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortByValue {
	public static void main(String[] args) {
			Map<Integer,String> fruits = new HashMap<>();
			
			fruits.put(5, "mango");
			fruits.put(2, "orange");
			fruits.put(1, "apple");
			fruits.put(4, "lichi");
			fruits.put(6, "guvava");
			System.out.println(fruits);
			
			for(Map.Entry<Integer, String> entry: fruits.entrySet()) {
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
			
			System.out.println("\nusing iterator");
			Iterator<Entry<Integer, String>> iterator = fruits.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Integer, String> kk = iterator.next();
				System.out.println(kk.getKey()+" "+kk.getValue());
			}
			
			System.out.println("\nafter sorting");
			Set<Entry<Integer, String>> entrySet = fruits.entrySet();
			ArrayList<Entry<Integer, String>> list = new ArrayList<>(entrySet);
			Collections.sort(list, new Comparator<>() {

				@Override
				public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
					return o2.getValue().compareToIgnoreCase(o1.getValue());
				}
			});
			list.forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
			
			System.out.println();
	}

}
