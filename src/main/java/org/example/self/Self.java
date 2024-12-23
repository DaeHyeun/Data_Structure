package org.example.self;

import java.net.Inet4Address;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

public class Self {
    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        int N = 500;
        long startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            arrayList.add(i);
            linkedList.add(N - i);
        }
        long endTime = System.nanoTime();
        for (int i = 0; i < arrayList.size(); i++) {
            if(i % 100 == 0) {
                System.out.println("arrayList : " + arrayList.get(i));
                System.out.println("LinkedList : " + linkedList.get(i));
            }
        }
        long insertTime = endTime - startTime;
        startTime = System.nanoTime();
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            map.put(arrayList.get(i),linkedList.get(i));
            if(i%100==0){
                System.out.println("i 번째 map값 : " + map.get(i));
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> iter = iterator.next();  // Get the next entry once
            System.out.println("HashMap = Key : " + iter.getKey() + "  value : " + iter.getValue());

        }

        endTime = System.nanoTime();
        long formatTime = endTime - startTime;

        System.out.println(" List 입력 경과시간 : " + insertTime);
        System.out.println("map으로 변경하는 시간 : " + formatTime);







    }
}
