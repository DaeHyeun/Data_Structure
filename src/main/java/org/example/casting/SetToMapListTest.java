package org.example.casting;

import java.util.*;

public class SetToMapListTest {
    public static void main(String[] args) {
        final int N = 50000; // 테스트할 데이터 크기

        // 테스트할 Set
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(i);
        }

        // Set -> Map 변환
        Map<Integer, Integer> mapFromSet = new HashMap<>();
        for (Integer element : set) {
            mapFromSet.put(element, element);
        }

        // Set -> List 변환
        List<Integer> listFromSet = new ArrayList<>(set);

        // Set -> Map 성능 테스트
        long startTime = System.nanoTime();
        for (Integer element : set) {
            mapFromSet.get(element);  // 검색
        }
        long endTimeMap = System.nanoTime();  // Map에 대한 종료 시간
        System.out.println("Set -> Map Search Time: " + (endTimeMap - startTime) / 1_000_000 + " ms");

        // Set -> List 성능 테스트
        startTime = System.nanoTime();  // List에 대한 시작 시간
        for (Integer element : set) {
            listFromSet.contains(element);  // 검색
        }
        long endTimeList = System.nanoTime();  // List에 대한 종료 시간
        System.out.println("Set -> List Search Time: " + (endTimeList - startTime) / 1_000_000 + " ms");
    }

}
