package org.example.progremmers;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    public static int solution(String[][] clothes) {
        // 의상 종류별로 의상 개수를 세기 위한 맵
        Map<String, Integer> clothesMap = new HashMap<>();

        // 의상의 종류를 기준으로 의상의 개수를 세기
        for (String[] cloth : clothes) {
            String type = cloth[1]; // 의상의 종류
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        // 모든 종류에서 의상 선택할 수 있는 경우의 수 구하기
        int result = 1; // 의상을 입지 않는 경우도 포함하므로 1로 초기화
        for (int count : clothesMap.values()) {
            result *= (count + 1); // 의상 개수 + 1 (입지 않음 포함)
        }

        // 최소 하나의 의상은 입어야 하므로, 모두 입지 않는 경우(1가지 경우)를 빼준다.
        return result - 1;
    }

    public static void main(String[] args) {

        // 예제 1
        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes1)); // 출력: 5

        // 예제 2
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(solution(clothes2)); // 출력: 3
    }


}
