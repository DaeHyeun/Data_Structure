package org.example.progremmers;

import java.util.ArrayList;
import java.util.List;

public class GiveUpMath {
    /* ==================================================================================================================================================================================
        수포자는 수학을 포기한 사람의 준말입니다.
        수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
        수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
        가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
    ================================================================================================================================================================================== */
    public static int[] solution(int[] answers) {
        // 수포자들의 답안 패턴
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 각 수포자가 맞춘 문제 수를 저장
        int[] score = new int[3];

        // answers 배열에 대해 각 수포자의 답안과 비교하여 맞춘 문제 수를 증가
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) {
                score[0]++;
            }
            if (answers[i] == person2[i % person2.length]) {
                score[1]++;
            }
            if (answers[i] == person3[i % person3.length]) {
                score[2]++;
            }
        }

        // 가장 많이 맞힌 사람을 찾아 반환할 리스트
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> result = new ArrayList<>();

        // 최대 점수를 가진 사람을 리스트에 추가
        for (int i = 0; i < 3; i++) {
            if (score[i] == maxScore) {
                result.add(i + 1); // 수포자는 1번부터 시작이므로 i + 1
            }
        }

        // 결과 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] result1 = solution(answers1);
        for (int i : result1) {
            System.out.print(i + " ");
        }
        // 출력: 1

        System.out.println();

        // 테스트 케이스 2
        int[] answers2 = {1, 3, 2, 4, 2};
        int[] result2 = solution(answers2);
        for (int i : result2) {
            System.out.print(i + " ");
        }
        // 출력: 1 2 3
    }
}
