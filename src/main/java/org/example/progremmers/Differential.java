package org.example.progremmers;

public class Differential {
    public static int solution(int[][] dots) {
        // 점들에서 두 직선의 기울기를 계산하고 비교
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) continue;  // 같은 점을 반복하지 않도록
                    for (int l = k + 1; l < 4; l++) {
                        if (l == i || l == j) continue;  // 같은 점을 반복하지 않도록

                        // (i, j)와 (k, l)을 연결하는 직선의 기울기 비교
                        int dy1 = dots[j][1] - dots[i][1]; // (y2 - y1)
                        int dx1 = dots[j][0] - dots[i][0]; // (x2 - x1)
                        int dy2 = dots[l][1] - dots[k][1]; // (y4 - y3)
                        int dx2 = dots[l][0] - dots[k][0]; // (x4 - x3)

                        // 기울기 비교: (dy1 / dx1) == (dy2 / dx2) -> dy1*dx2 == dy2*dx1
                        if (dy1 * dx2 == dy2 * dx1) {
                            return 1; // 평행이면 1 반환
                        }
                    }
                }
            }
        }
        return 0; // 평행하지 않으면 0 반환
    }

    public static void main(String[] args) {
        int[][] dots= {
                {1,4},
                {9,2},
                {3,8},
                {11,6}
        };
        int answer = solution(dots);
        System.out.println("=============================================");
        System.out.println(answer);
        System.out.println("=============================================");

    }
}
