package org.example.stress;

import java.util.*;

public class DataStructureStressTest {
    public static void main(String[] args) {
        final int N = 50000; // 테스트할 데이터 크기

        // 테스트할 자료구조 리스트
        List<Object> listTypes = Arrays.asList(
                new ArrayList<Integer>(), new LinkedList<Integer>(),
                new HashMap<Integer, Integer>(), new TreeMap<Integer, Integer>(),
                new HashSet<Integer>(), new TreeSet<Integer>()
        );

        // 데이터 삽입, 검색 및 정렬 성능 테스트
        for (Object structure : listTypes) {
            if (structure instanceof List) {
                List<Integer> list = (List<Integer>) structure;

                // 데이터 삽입
                long startTime = System.nanoTime();
                for (int i = 0; i < N; i++) {
                    list.add(i);
                }
                long endTime = System.nanoTime();
                System.out.println(list.getClass().getSimpleName() + " - Insert Time: " + (endTime - startTime) / 1_000_000 + " ms");

                // 데이터 검색 (간단한 index 접근)
                startTime = System.nanoTime();
                for (int i = 0; i < N; i++) {
                    list.get(i);
                }
                endTime = System.nanoTime();
                System.out.println(list.getClass().getSimpleName() + " - Search Time: " + (endTime - startTime) / 1_000_000 + " ms");

                // 데이터 정렬
                startTime = System.nanoTime();
                Collections.sort(list);
                endTime = System.nanoTime();
                System.out.println(list.getClass().getSimpleName() + " - Sort Time: " + (endTime - startTime) / 1_000_000 + " ms");

            } else if (structure instanceof Map) {
                Map<Integer, Integer> map = (Map<Integer, Integer>) structure;

                // 데이터 삽입
                long startTime = System.nanoTime();
                for (int i = 0; i < N; i++) {
                    map.put(i, i);
                }
                long endTime = System.nanoTime();
                System.out.println(map.getClass().getSimpleName() + " - Insert Time: " + (endTime - startTime) / 1_000_000 + " ms");

                // 데이터 검색
                startTime = System.nanoTime();
                for (int i = 0; i < N; i++) {
                    map.get(i);
                }
                endTime = System.nanoTime();
                System.out.println(map.getClass().getSimpleName() + " - Search Time: " + (endTime - startTime) / 1_000_000 + " ms");

            } else if (structure instanceof Set) {
                Set<Integer> set = (Set<Integer>) structure;

                // 데이터 삽입
                long startTime = System.nanoTime();
                for (int i = 0; i < N; i++) {
                    set.add(i);
                }
                long endTime = System.nanoTime();
                System.out.println(set.getClass().getSimpleName() + " - Insert Time: " + (endTime - startTime) / 1_000_000 + " ms");

                // 데이터 검색
                startTime = System.nanoTime();
                for (int i = 0; i < N; i++) {
                    set.contains(i);
                }
                endTime = System.nanoTime();
                System.out.println(set.getClass().getSimpleName() + " - Search Time: " + (endTime - startTime) / 1_000_000 + " ms");
            }
            System.out.println("------------------------------------------------");
        }
    }
}
