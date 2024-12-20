package org.example.stress;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapStressTest {
    public static void main(String[] args) {
        final int N = 50000; // 테스트할 데이터 크기

        // 맵 자료구조들
        Map<String, Map<Object, Object>> mapTypes = new HashMap<>();
        mapTypes.put("HashMap", new HashMap<Object, Object>());
        mapTypes.put("TreeMap", new TreeMap<Object, Object>());

        // 데이터 삽입, 검색 성능 테스트
        for (Map.Entry<String, Map<Object, Object>> entry : mapTypes.entrySet()) {
            Map<Object, Object> map = entry.getValue();

            // 데이터 삽입
            long startTime = System.nanoTime();
            for (int i = 0; i < N; i++) {
                map.put(i, i);
            }
            long endTime = System.nanoTime();
            System.out.println(entry.getKey() + " - Insert Time: " + (endTime - startTime) / 1_000_000 + " ms");

            // 데이터 검색
            startTime = System.nanoTime();
            for (int i = 0; i < N; i++) {
                map.get(i);
            }
            endTime = System.nanoTime();
            System.out.println(entry.getKey() + " - Search Time: " + (endTime - startTime) / 1_000_000 + " ms");

            System.out.println("------------------------------------------------");
        }
    }
}
