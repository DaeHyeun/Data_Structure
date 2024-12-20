package org.example;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {

        // Set을 저장하는 List
        List<Set<String>> listOfSets = new ArrayList<>();

        Set<String> set1 = new HashSet<>();
        set1.add("Apple");
        set1.add("Banana");

        Set<String> set2 = new HashSet<>();
        set2.add("Orange");
        set2.add("Grape");

        listOfSets.add(set1);
        listOfSets.add(set2);

        // 리스트의 각 Set 출력
        for (Set<String> set : listOfSets) {
            System.out.println(set);
        }

        // Map을 저장하는 List
        List<Map<String, String>> listOfMaps = new ArrayList<>();

        Map<String, String> map1 = new HashMap<>();
        map1.put("A", "Apple");
        map1.put("B", "Banana");

        Map<String, String> map2 = new HashMap<>();
        map2.put("C", "Cherry");
        map2.put("D", "Date");

        listOfMaps.add(map1);
        listOfMaps.add(map2);

        // 리스트의 각 Map 출력
        for (Map<String, String> map : listOfMaps) {
            System.out.println(map);
        }

        // Stack과 Queue를 결합한 예시
        Queue<Stack<String>> queueOfStacks = new LinkedList<>();

        Stack<String> stack1 = new Stack<>();
        stack1.push("Apple");
        stack1.push("Banana");

        Stack<String> stack2 = new Stack<>();
        stack2.push("Orange");
        stack2.push("Grape");

        queueOfStacks.add(stack1);
        queueOfStacks.add(stack2);

        // Queue의 각 Stack 출력
        while (!queueOfStacks.isEmpty()) {
            Stack<String> stack = queueOfStacks.poll();
            System.out.println(stack);
        }

    }
}
