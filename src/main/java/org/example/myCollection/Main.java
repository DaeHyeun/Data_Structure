package org.example.myCollection;

public class Main {
    public static void main(String[] args) {
        // MyArrayList 객체 생성
        MyArrayList<String> list = new MyArrayList<>();

        // 요소 추가
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // 리스트 크기 출력
        System.out.println("List size: " + list.size());  // 3

        // 특정 인덱스의 요소 출력
        System.out.println("Element at index 1: " + list.get(1));  // Banana

        // 인덱스 1에 새로운 요소 삽입
        list.add(1, "Orange");

        // 리스트 크기 출력 (변경된 크기)
        System.out.println("List size after insertion: " + list.size());  // 4

        // 리스트에서 요소 삭제 (인덱스 2의 요소 삭제)
        String removedElement = list.remove(2);
        System.out.println("Removed element: " + removedElement);  // Cherry

        // 삭제 후 리스트 크기 출력
        System.out.println("List size after removal: " + list.size());  // 3

        // 리스트의 모든 요소 출력
        System.out.println("List elements:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        // MyHashSet 테스트
        MyHashSet<String> set = new MyHashSet<>();
        System.out.println("MyHashSet 테스트");

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // 중복 추가 (추가되지 않아야 함)

        System.out.println("Set size: " + set.size());  // 3
        System.out.println("Contains 'Banana': " + set.contains("Banana"));  // true
        System.out.println("Contains 'Orange': " + set.contains("Orange"));  // false

        set.remove("Banana");
        System.out.println("Set size after removal: " + set.size());  // 2
        System.out.println("Contains 'Banana' after removal: " + set.contains("Banana"));  // false

        System.out.println();

        // MyHashMap 테스트
        MyHashMap<String, Integer> map = new MyHashMap<>();
        System.out.println("MyHashMap 테스트");

        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        System.out.println("Map size: " + map.size());  // 3
        System.out.println("Value for key 'Banana': " + map.get("Banana"));  // 2
        System.out.println("Value for key 'Orange': " + map.get("Orange"));  // null

        map.remove("Banana");
        System.out.println("Map size after removal: " + map.size());  // 2
        System.out.println("Value for key 'Banana' after removal: " + map.get("Banana"));  // null
    }

}
