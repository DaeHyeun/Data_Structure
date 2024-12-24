package org.example.progremmers;

public class NumCountry {
    public static int solution(int number, int limit, int power) {
        int steal = 0;

        for (int i = 1; i <= number; i++) {
            int cnt = 0;

            // i의 약수 개수를 구하는 과정 (O(sqrt(i)))
            // i = 4
            // j = 1, 2
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    // j가 i의 약수일 때
                    cnt++;
                    if (j != i / j) {
                        // i / j도 i의 약수이면, 다른 약수도 추가
                        cnt++;
                    }
                }
            }

            // 약수가 limit을 초과하면 power로 설정
            if (cnt > limit) {
                steal += power;
            } else {
                steal += cnt;
            }
        }

        return steal;
    }

    public static void main(String[] args) {
        int answer = solution(5,3,2);
        System.out.println(answer);
    }

}
