package org.example.performanceTest;

import java.util.*;
import java.util.concurrent.*;

public class CollectionPerformanceTest {

    public static void main(String[] args) {
        // 테스트할 Map 종류들
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Map<String, String> hashtable = new Hashtable<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        // 테스트할 Set 종류들
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        // 테스트할 List 종류들
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        // 각 Map에 대해 성능 테스트 수행
        System.out.println("=== Map Performance Test ===");
        testMapPerformance("HashMap", hashMap);
        testMapPerformance("TreeMap", treeMap);
        testMapPerformance("LinkedHashMap", linkedHashMap);
        testMapPerformance("Hashtable", hashtable);
        testMapPerformance("ConcurrentHashMap", concurrentHashMap);

        // 각 Set에 대해 성능 테스트 수행
        System.out.println("=== Set Performance Test ===");
        testSetPerformance("HashSet", hashSet);
        testSetPerformance("TreeSet", treeSet);
        testSetPerformance("LinkedHashSet", linkedHashSet);
        testSetPerformance("CopyOnWriteArraySet", copyOnWriteArraySet);

        // 각 List에 대해 성능 테스트 수행
        System.out.println("=== List Performance Test ===");
        testListPerformance("ArrayList", arrayList);
        testListPerformance("LinkedList", linkedList);
        testListPerformance("Vector", vector);
        testListPerformance("CopyOnWriteArrayList", copyOnWriteArrayList);
    }

    private static void testMapPerformance(String mapType, Map<String, String> map) {
        // 테스트할 데이터 수
        int size = 100000;
        Random random = new Random();

        // Map 초기화
        for (int i = 0; i < size; i++) {
            map.put("Key-" + i, "Value-" + random.nextInt(size));  // 랜덤 데이터로 초기화
        }

        // put 작업 성능 측정
        long startTime = System.nanoTime();
        map.put("NewKey", "NewValue");
        long endTime = System.nanoTime();
        long durationPut = endTime - startTime;

        // get 작업 성능 측정
        startTime = System.nanoTime();
        map.get("Key-" + random.nextInt(size));  // 랜덤으로 데이터 접근
        endTime = System.nanoTime();
        long durationGet = endTime - startTime;

        // remove 작업 성능 측정
        startTime = System.nanoTime();
        map.remove("Key-" + random.nextInt(size));  // 랜덤으로 데이터 삭제
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;

        // Sort 작업 (Map 정렬)
        long durationSort = 0;
        if (!(map instanceof TreeMap)) {
            startTime = System.nanoTime();
            List<Map.Entry<String, String>> entries = new ArrayList<>(map.entrySet());
            entries.sort(Map.Entry.comparingByKey());  // 키 기준으로 정렬
            durationSort = System.nanoTime() - startTime;
        }

        // 결과 출력
        System.out.println(mapType + ":");
        System.out.println("  Put Operation: " + durationPut / 1000 + " microseconds");
        System.out.println("  Get Operation: " + durationGet / 1000 + " microseconds");
        System.out.println("  Remove Operation: " + durationRemove / 1000 + " microseconds");
        System.out.println("  Sort Operation (by Key): " + durationSort / 1000 + " microseconds");
        System.out.println();
    }

    private static void testSetPerformance(String setType, Set<String> set) {
        // 테스트할 데이터 수
        int size = 100000;
        Random random = new Random();

        // Set 초기화
        for (int i = 0; i < size; i++) {
            set.add("Element-" + random.nextInt(size));  // 랜덤 데이터로 초기화
        }

        // add 작업 성능 측정
        long startTime = System.nanoTime();
        set.add("NewElement");
        long endTime = System.nanoTime();
        long durationAdd = endTime - startTime;

        // contains 작업 성능 측정
        startTime = System.nanoTime();
        set.contains("Element-" + random.nextInt(size));  // 랜덤으로 데이터 존재 여부 확인
        endTime = System.nanoTime();
        long durationContains = endTime - startTime;

        // remove 작업 성능 측정
        startTime = System.nanoTime();
        set.remove("Element-" + random.nextInt(size));  // 랜덤으로 데이터 삭제
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;

        // Sort 작업 (Set 정렬)
        long durationSort = 0;
        if (!(set instanceof TreeSet)) {
            startTime = System.nanoTime();
            List<String> list = new ArrayList<>(set);
            Collections.sort(list);  // 기본 오름차순으로 정렬
            durationSort = System.nanoTime() - startTime;
        }

        // 결과 출력
        System.out.println(setType + ":");
        System.out.println("  Add Operation: " + durationAdd / 1000 + " microseconds");
        System.out.println("  Contains Operation: " + durationContains / 1000 + " microseconds");
        System.out.println("  Remove Operation: " + durationRemove / 1000 + " microseconds");
        System.out.println("  Sort Operation: " + durationSort / 1000 + " microseconds");
        System.out.println();
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
