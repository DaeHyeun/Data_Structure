package org.example.manufacturingProcessSimulation;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ManufacturingProcessSimulation {
    // 랜덤 데이터 생성 함수
    public static String generateRandomData() {
        Random random = new Random();
        int processId = random.nextInt(1000); // 0부터 999 사이의 랜덤 숫자
        return "Process ID: " + processId + ", Time: " + System.currentTimeMillis();
    }

    public static void main(String[] args) throws InterruptedException {
        // List<Map> 구조 생성
        List<Map<String, String>> processListMap = new ArrayList<>(); // List에 여러 Map을 저장

        // 10초 동안 랜덤 데이터 생성
        long endTime = System.currentTimeMillis() + 10 * 1000; // 10초 뒤의 시간
        Map<String, String> processData = null;
        while (System.currentTimeMillis() < endTime) {
            // 1초마다 랜덤 데이터 생성
            String data = generateRandomData();

            // 새로운 Map 생성
            processData = new HashMap<>();
            processData.put("processId", "Process-" + data.hashCode());
            processData.put("data", data);

            // List에 Map 추가
            processListMap.add(processData);

            // 생성된 데이터 출력
            System.out.println("Data Generated: " + data);

            // 1초 대기
            TimeUnit.SECONDS.sleep(1);
        }

        // List<Map>의 데이터를 출력
        System.out.println("\n--- Final Process Data in List<Map> ---");
        for (Map<String, String> map : processListMap) {
            System.out.println(map);
        }

        // List<Map>을 Set으로 변환 (Set은 중복을 허용하지 않음)
        Set<Map<String, String>> processSet = new HashSet<>(processListMap);
        System.out.println("\n--- Final Process Data in Set (No duplicates) ---");
        for (Map<String, String> map : processSet) {
            System.out.println(map);
        }

        // List<Map>을 다른 List로 변환 (예: 다른 형식으로 가공)
        List<String> processIdList = new ArrayList<>();
        for (Map<String, String> map : processListMap) {
            String processId = map.get("processId");
            processIdList.add(processId);
        }
        System.out.println("\n--- Final Process IDs in List ---");
        for (String processId : processIdList) {
            System.out.println(processId);
        }

        // List<Map>을 Map으로 변환 (processId를 키로, 전체 데이터를 값으로 저장)
        Map<String, Map<String, String>> processMap = new HashMap<>();
        for (Map<String, String> map : processListMap) {
            String processId = map.get("processId");
            processMap.put(processId, map);
        }
        System.out.println("\n--- Final Process Data in Map (processId as key) ---");
        for (Map.Entry<String, Map<String, String>> entry : processMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println("프로세스 아이디 리스트");
        System.out.println(processIdList.size());
        System.out.println("프로세스 데이터 사이즈");
        System.out.println(processData.size());
        System.out.println("processMap size");
        System.out.println(processMap.size());
        System.out.println("processSet size");
        System.out.println(processSet.size());
    }
}
