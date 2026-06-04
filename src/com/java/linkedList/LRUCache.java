package com.java.linkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int capacity;
    public LRUCache(int capacity){
        super(capacity,0.75f,true);
        this.capacity=capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>capacity;
    }
    public static void main(String[] args) {
        LRUCache<String,Integer> studentInfo = new LRUCache<>(3);
        studentInfo.put("akash",27);
        studentInfo.put("nandani",24);
        studentInfo.put("samay",25);

        studentInfo.put("manav",30);

        studentInfo.forEach((k,v)->{
            System.out.println(k+" = "+v);
        });
    }
}
