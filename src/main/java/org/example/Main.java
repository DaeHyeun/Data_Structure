package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. ArrayList 예시
        System.out.println("=== ArrayList ===");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Orange");
        System.out.println(arrayList);  // ArrayList 출력

        // 2. HashSet 예시
        System.out.println("=== HashSet ===");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Apple"); // 중복된 요소는 추가되지 않음
        System.out.println(hashSet);  // HashSet 출력

        // 3. HashMap 예시
        System.out.println("=== HashMap ===");
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "Apple");
        hashMap.put("B", "Banana");
        hashMap.put("C", "Cherry");
        System.out.println(hashMap);  // HashMap 출력

        // 4. PriorityQueue 예시
        System.out.println("=== PriorityQueue ===");
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        System.out.println(priorityQueue);  // PriorityQueue 출력 (우선순위에 따라 자동으로 정렬됨)

        // 5. Stack 예시
        System.out.println("=== Stack ===");
        Stack<String> stack = new Stack<>();
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Orange");
        System.out.println(stack);  // Stack 출력

        // 6. LinkedList 예시 (큐로 사용)
        System.out.println("=== LinkedList as Queue ===");
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.add("Apple");
        linkedListQueue.add("Banana");
        linkedListQueue.add("Orange");
        System.out.println(linkedListQueue);  // LinkedList를 큐로 사용한 출력

        // 7. TreeSet 예시
        System.out.println("=== TreeSet ===");
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Orange");
        System.out.println(treeSet);  // TreeSet 출력 (자동으로 정렬됨)

        List list = new ArrayList();
        list.add("Apple");
        list.add("Banana");
        list.add(123);  // Integer 타입도 추가 가능, 타입 안전성이 없음

        List<Object> list2 = new ArrayList<>();
        list2.add("apple");
        list2.add("Banana");
        list2.add(123);

        // 출력
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(list);
        System.out.println("List");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getClass());
        }
        System.out.println();
        System.out.println("List2");
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).getClass());
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

    }
}