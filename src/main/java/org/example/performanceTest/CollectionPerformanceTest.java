package org.example.performanceTest;

import java.util.*;
import java.util.concurrent.*;

public class CollectionPerformanceTest {
    public static void main(String[] args) {
        // 리스트 종류들
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        List<String> vector = new Vector<>();
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        // Set 종류들
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        // Map 종류들
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Map<String, String> hashtable = new Hashtable<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        // Queue 종류들
        Queue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(100000);
        Queue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        Queue<String> priorityQueue = new PriorityQueue<>();

        // Stack 종류들
        Stack<String> stack = new Stack<>();
        Deque<String> arrayDeque = new ArrayDeque<>();

        // 성능 테스트 실행
        System.out.println("=== List Performance Test ===");
        testListPerformance("ArrayList", arrayList);
        testListPerformance("LinkedList", linkedList);
        testListPerformance("Vector", vector);
        testListPerformance("CopyOnWriteArrayList", copyOnWriteArrayList);

        System.out.println("=== Set Performance Test ===");
        testSetPerformance("HashSet", hashSet);
        testSetPerformance("TreeSet", treeSet);
        testSetPerformance("LinkedHashSet", linkedHashSet);
        testSetPerformance("CopyOnWriteArraySet", copyOnWriteArraySet);

        System.out.println("=== Map Performance Test ===");
        testMapPerformance("HashMap", hashMap);
        testMapPerformance("TreeMap", treeMap);
        testMapPerformance("LinkedHashMap", linkedHashMap);
        testMapPerformance("Hashtable", hashtable);
        testMapPerformance("ConcurrentHashMap", concurrentHashMap);

        System.out.println("=== Queue Performance Test ===");
        testQueuePerformance("ArrayBlockingQueue", arrayBlockingQueue);
        testQueuePerformance("LinkedBlockingQueue", linkedBlockingQueue);
        testQueuePerformance("PriorityQueue", priorityQueue);

        System.out.println("=== Stack Performance Test ===");
        testStackPerformance("Stack", stack);
        testDequePerformance("ArrayDeque", arrayDeque);
    }

    private static void testListPerformance(String listType, List<String> list) {
        int size = 100000;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add("Element-" + random.nextInt(size));
        }

        // Add 작업
        long startTime = System.nanoTime();
        list.add("NewElement");
        long endTime = System.nanoTime();
        long durationAdd = endTime - startTime;

        // Get 작업
        startTime = System.nanoTime();
        list.get(random.nextInt(size));
        endTime = System.nanoTime();
        long durationGet = endTime - startTime;

        // Remove 작업
        startTime = System.nanoTime();
        list.remove(random.nextInt(size));
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;

        // Sort 작업
        startTime = System.nanoTime();
        Collections.sort(list);
        endTime = System.nanoTime();
        long durationSort = endTime - startTime;

        System.out.println(listType + ":");
        System.out.println("  Add Operation: " + durationAdd / 1000 + " microseconds");
        System.out.println("  Get Operation: " + durationGet / 1000 + " microseconds");
        System.out.println("  Remove Operation: " + durationRemove / 1000 + " microseconds");
        System.out.println("  Sort Operation: " + durationSort / 1000 + " microseconds");
        System.out.println();
    }

    private static void testSetPerformance(String setType, Set<String> set) {
        int size = 100000;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            set.add("Element-" + random.nextInt(size));
        }

        // Add 작업
        long startTime = System.nanoTime();
        set.add("NewElement");
        long endTime = System.nanoTime();
        long durationAdd = endTime - startTime;

        // Contains 작업
        startTime = System.nanoTime();
        set.contains("Element-" + random.nextInt(size));
        endTime = System.nanoTime();
        long durationContains = endTime - startTime;

        // Remove 작업
        startTime = System.nanoTime();
        set.remove("Element-" + random.nextInt(size));
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;

        // Sort 작업
        long durationSort = 0;
        if (!(set instanceof TreeSet)) {
            startTime = System.nanoTime();
            List<String> list = new ArrayList<>(set);
            Collections.sort(list);
            durationSort = System.nanoTime() - startTime;
        }

        System.out.println(setType + ":");
        System.out.println("  Add Operation: " + durationAdd / 1000 + " microseconds");
        System.out.println("  Contains Operation: " + durationContains / 1000 + " microseconds");
        System.out.println("  Remove Operation: " + durationRemove / 1000 + " microseconds");
        System.out.println("  Sort Operation: " + durationSort / 1000 + " microseconds");
        System.out.println();
    }

    private static void testMapPerformance(String mapType, Map<String, String> map) {
        int size = 100000;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            map.put("Key-" + i, "Value-" + random.nextInt(size));
        }

        // Put 작업
        long startTime = System.nanoTime();
        map.put("NewKey", "NewValue");
        long endTime = System.nanoTime();
        long durationPut = endTime - startTime;

        // Get 작업
        startTime = System.nanoTime();
        map.get("Key-" + random.nextInt(size));
        endTime = System.nanoTime();
        long durationGet = endTime - startTime;

        // Remove 작업
        startTime = System.nanoTime();
        map.remove("Key-" + random.nextInt(size));
        endTime = System.nanoTime();
        long durationRemove = endTime - startTime;

        // Sort 작업
        long durationSort = 0;
        if (!(map instanceof TreeMap)) {
            startTime = System.nanoTime();
            List<Map.Entry<String, String>> entries = new ArrayList<>(map.entrySet());
            entries.sort(Map.Entry.comparingByKey());
            durationSort = System.nanoTime() - startTime;
        }

        System.out.println(mapType + ":");
        System.out.println("  Put Operation: " + durationPut / 1000 + " microseconds");
        System.out.println("  Get Operation: " + durationGet / 1000 + " microseconds");
        System.out.println("  Remove Operation: " + durationRemove / 1000 + " microseconds");
        System.out.println("  Sort Operation (by Key): " + durationSort / 1000 + " microseconds");
        System.out.println();
    }

    private static void testQueuePerformance(String queueType, Queue<String> queue) {
        int size = 100000;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            queue.offer("Element-" + random.nextInt(size));
        }

        // Offer 작업
        long startTime = System.nanoTime();
        queue.offer("NewElement");
        long endTime = System.nanoTime();
        long durationOffer = endTime - startTime;

        // Peek 작업
        startTime = System.nanoTime();
        queue.peek();
        endTime = System.nanoTime();
        long durationPeek = endTime - startTime;

        // Poll 작업
        startTime = System.nanoTime();
        queue.poll();
        endTime = System.nanoTime();
        long durationPoll = endTime - startTime;

        System.out.println(queueType + ":");
        System.out.println("  Offer Operation: " + durationOffer / 1000 + " microseconds");
        System.out.println("  Peek Operation: " + durationPeek / 1000 + " microseconds");
        System.out.println("  Poll Operation: " + durationPoll / 1000 + " microseconds");
        System.out.println();
    }

    private static void testStackPerformance(String stackType, Stack<String> stack) {
        int size = 100000;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            stack.push("Element-" + random.nextInt(size));
        }

        // Push 작업
        long startTime = System.nanoTime();
        stack.push("NewElement");
        long endTime = System.nanoTime();
        long durationPush = endTime - startTime;

        // Peek 작업
        startTime = System.nanoTime();
        stack.peek();
        endTime = System.nanoTime();
        long durationPeek = endTime - startTime;

        // Pop 작업
        startTime = System.nanoTime();
        stack.pop();
        endTime = System.nanoTime();
        long durationPop = endTime - startTime;

        System.out.println(stackType + ":");
        System.out.println("  Push Operation: " + durationPush / 1000 + " microseconds");
        System.out.println("  Peek Operation: " + durationPeek / 1000 + " microseconds");
        System.out.println("  Pop Operation: " + durationPop / 1000 + " microseconds");
        System.out.println();
    }

    private static void testDequePerformance(String dequeType, Deque<String> deque) {
        int size = 100000;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            deque.offer("Element-" + random.nextInt(size));
        }

        // OfferFirst 작업
        long startTime = System.nanoTime();
        deque.offerFirst("NewElement");
        long endTime = System.nanoTime();
        long durationOfferFirst = endTime - startTime;

        // PeekFirst 작업
        startTime = System.nanoTime();
        deque.peekFirst();
        endTime = System.nanoTime();
        long durationPeekFirst = endTime - startTime;

        // PollFirst 작업
        startTime = System.nanoTime();
        deque.pollFirst();
        endTime = System.nanoTime();
        long durationPollFirst = endTime - startTime;

        System.out.println(dequeType + ":");
        System.out.println("  OfferFirst Operation: " + durationOfferFirst / 1000 + " microseconds");
        System.out.println("  PeekFirst Operation: " + durationPeekFirst / 1000 + " microseconds");
        System.out.println("  PollFirst Operation: " + durationPollFirst / 1000 + " microseconds");
        System.out.println();
    }
}
