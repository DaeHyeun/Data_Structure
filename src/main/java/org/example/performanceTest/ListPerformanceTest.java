package org.example.performanceTest;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListPerformanceTest {
    public static void main(String[] args) {
        // 테스트할 리스트 종류들
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        // 각 리스트에 대해 성능 테스트 수행
        System.out.println("=== Performance Test ===");
        testListPerformance("ArrayList", arrayList);
        testListPerformance("LinkedList", linkedList);
        testListPerformance("Vector", vector);
        testListPerformance("CopyOnWriteArrayList", copyOnWriteArrayList);
    }

    private static void testListPerformance(String listType, List<String> list) {
        // 테스트할 데이터 수
        int size = 100000;
        Random random = new Random();

        // 리스트 초기화
        for (int i = 0; i < size; i++) {
            list.add("Element-" + i);
        }

        // Add 작업 성능 측정
        long startTime = System.nanoTime();
        list.add("NewElement");
        long endTime = System.nanoTime();
        long durationAdd = endTime - startTime;

        // Get 작업 성능 측정
        startTime = System.nanoTime();
        list.get(random.nextInt(size));  // 랜덤으로 요소 접근
        endTime = System.nanoTime();
        long durationGet = endTime - startTime;

        // Remove 작업 성능 측정
        startTime = System.nanoTime();
        list.remove(random.nextInt(size));  // 랜덤으로 요소 삭제
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;

        // Sort 작업 성능 측정
        startTime = System.nanoTime();
        Collections.sort(list);  // 정렬
        endTime = System.nanoTime();
        long durationSort = endTime - startTime;

        // 결과 출력
        System.out.println(listType + ":");
        System.out.println("  Add Operation: " + durationAdd / 1000 + " microseconds");
        System.out.println("  Get Operation: " + durationGet / 1000 + " microseconds");
        System.out.println("  Remove Operation: " + durationRemove / 1000 + " microseconds");
        System.out.println("  Sort Operation: " + durationSort / 1000 + " microseconds");
        System.out.println();
    }
}
