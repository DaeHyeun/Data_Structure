package org.example.casting;

import java.util.*;

public class ListToMapSetTest {
    public static void main(String[] args) {
        final int N = 50000; // 테스트할 데이터 크기

        // 테스트할 List
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }

        // List -> Map 변환
        Map<Integer, Integer> mapFromList = new HashMap<>();
        for (int i = 0; i < N; i++) {
            mapFromList.put(i, i);
        }

        // List -> Set 변환
        Set<Integer> setFromList = new HashSet<>(list);

        // List -> Map 성능 테스트
        long startTime = System.nanoTime();
        for (Integer element : list) {
            mapFromList.get(element);  // 검색
        }
        long endTime = System.nanoTime();
        System.out.println("List -> Map Search Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // List -> Set 성능 테스트
        startTime = System.nanoTime();
        for (Integer element : list) {
            setFromList.contains(element);  // 검색
        }
        long endTimeList = System.nanoTime();  // List에 대한 종료 시간
        System.out.println("List -> Set Search Time: " + (endTimeList - startTime) / 1_000_000 + " ms");
    }
}
