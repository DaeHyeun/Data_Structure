package org.example.stress;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetStressTest {
    public static void main(String[] args) {
        final int N = 50000; // 테스트할 데이터 크기

        // 세트 자료구조들
        Set<Object> setTypes = new HashSet<>(Arrays.asList(
                new HashSet<Object>(), new TreeSet<Object>()
        ));

        // 데이터 삽입, 검색 성능 테스트
        for (Object structure : setTypes) {
            if (structure instanceof Set) {
                Set<Object> set = (Set<Object>) structure;

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
