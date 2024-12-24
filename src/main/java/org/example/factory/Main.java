package org.example.factory;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create data for Module1: List<List<Integer>>
        List<List<Integer>> data = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6)
        );

        // Create instances of Module1, Module2, Module3, and Module4 with sample data
        Module1 module1 = new Module1(data);  // Module1 requires List<List<Integer>>

        // Module2 requires a HashMap<String, Integer>
        // 익명클레스
        // new HashMap<>() {{...}} 형태로 생성한 코드에서 익명 클래스가 생성
        // 익명 클래스가 생성된 위치에 따라 Main$1, Main$2와 같이 출력됩니다
        Module2 module2 = new Module2(new HashMap<>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
            put("d", 4);
            put("e", 5);
        }});

        // Module3 requires a HashMap<String, String>
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("key1", "value1");
        map3.put("key2", "value2");
        map3.put("key3", "value3");
        map3.put("key4", "value4");
        map3.put("key5", "value5");
        Module3 module3 = new Module3(map3);

        // Module4 requires a Set<String>
        Set<String> stringSet = new HashSet<>(Arrays.asList("apple", "banana", "cherry", "date", "elderberry"));
        Module4 module4 = new Module4(stringSet);

        Queue<String> stringQueue = new PriorityQueue<>();
        stringQueue.add("aa");
        stringQueue.add("bb");
        stringQueue.add("cc");
        stringQueue.add("dd");
        stringQueue.add("ee");
        Module5 module5 =  new Module5(stringQueue);

        Stack<String> stringStack = new Stack<>();
        stringStack.add("AA");
        stringStack.add("BB");
        stringStack.add("CC");
        stringStack.add("DD");
        stringStack.add("EE");
        Module6 module6 = new Module6(stringStack);


        // Create the CollectionModule that combines the data from all modules
        CollectionModule collectionModule = new CollectionModule(module1, module2, module3, module4, module5, module6);

        // Output the combined collection of data
        HashMap<String, Object> collectedData = collectionModule.collect();
        System.out.println("Combined Data: " + collectedData);
        System.out.println();
        System.out.println("=========================================================");
        System.out.println();
        for (String key : collectedData.keySet()) {
            Object value = collectedData.get(key);  // key에 대응하는 값을 가져옴
            System.out.print("Key: " + key + ", Value: " + value);
            System.out.println("  ====   Class: " + value.getClass());
            System.out.println();
        }
    }

}
