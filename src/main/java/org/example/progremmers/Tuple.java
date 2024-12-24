package org.example.progremmers;

import java.util.*;

public class Tuple {
    /* ==================================================================================================================================================================================
        셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다.
        n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.

        (a1, a2, a3, ..., an)
        튜플은 다음과 같은 성질을 가지고 있습니다.

        중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
        원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
        튜플의 원소 개수는 유한합니다.
        원소의 개수가 n개이고,
        중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때(단, a1, a2, ..., an은 자연수),
        이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.

        {{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
        예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는

        {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
        와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로

        {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
        {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
        {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
        는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.

        특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때,
        s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.
    ================================================================================================================================================================================== */
    public int[] solution(String s) {
        // 결과를 저장할 리스트
        List<Integer> resultList = new ArrayList<>();

        // 입력 문자열에서 중괄호를 기준으로 각 집합을 분리
        s = s.substring(1, s.length() - 1); // 맨 앞과 맨 뒤의 '{}' 제거
        String[] sets = s.split("},\\{"); // '},{' 기준으로 분리

        // 각 집합을 크기 순으로 정렬하기 위해, 집합의 크기를 기준으로 정렬할 준비
        List<Set<Integer>> tupleSets = new ArrayList<>();

        // 각 집합을 Set<Integer>로 변환하고 크기 순으로 추가
        for (String set : sets) {
            set = set.replace("{", "").replace("}", ""); // '{'와 '}' 제거
            String[] elements = set.split(",");
            Set<Integer> elementSet = new HashSet<>();
            for (String element : elements) {
                elementSet.add(Integer.parseInt(element));
            }
            tupleSets.add(elementSet);
        }

        // 집합의 크기 순으로 정렬
        tupleSets.sort((a, b) -> a.size() - b.size());

        // 튜플 복원
        Set<Integer> prevSet = new HashSet<>();
        for (Set<Integer> set : tupleSets) {
            // 새로 등장한 원소 찾기 (현재 집합에서 이전 집합을 제외한 원소)
            for (Integer element : set) {
                if (!prevSet.contains(element)) {
                    resultList.add(element);
                    prevSet.add(element);
                    break; // 한 번 찾으면 더 이상 찾을 필요 없음
                }
            }
        }

        // 결과를 배열로 변환
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s1 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s2 = "{{20,111},{111}}";
        String s3 = "{{123}}";
        String s4 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        /*
        [2, 1, 3, 4]
        [2, 1, 3, 4]
        [111, 20]
        [123]
        [3, 2, 4, 1]
        */
        System.out.println(Arrays.toString(tuple.solution(s)));
        System.out.println(Arrays.toString(tuple.solution(s1)));
        System.out.println(Arrays.toString(tuple.solution(s2)));
        System.out.println(Arrays.toString(tuple.solution(s3)));
        System.out.println(Arrays.toString(tuple.solution(s4)));

    }
}
