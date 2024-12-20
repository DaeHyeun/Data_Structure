package org.example.casting;

import java.util.*;

public class MapToListSetTest {
    public static void main(String[] args) {
        final int N = 50000; // 테스트할 데이터 크기

        // 테스트할 Map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, i);
        }

        // Map -> List 변환
        List<Integer> listFromMap = new ArrayList<>(map.keySet());

        // Map -> Set 변환
        Set<Integer> setFromMap = new HashSet<>(map.keySet());

        // Map -> List 성능 테스트
        long startTime = System.nanoTime();
        for (Integer key : map.keySet()) {
            listFromMap.contains(key);  // 검색
        }
        long endTime = System.nanoTime();
        System.out.println("Map -> List Search Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Map -> Set 성능 테스트
        startTime = System.nanoTime();
        for (Integer key : map.keySet()) {
            setFromMap.contains(key);  // 검색
        }
        endTime = System.nanoTime();
        System.out.println("Map -> Set Search Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }
}
