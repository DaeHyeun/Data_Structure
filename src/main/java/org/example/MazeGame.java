package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class MazeGame {
    static final int N = 5;  // 미로 크기
    static int[][] maze = {
            {1, 0, 1, 1, 0},
            {1, 1, 1, 0, 1},
            {0, 0, 1, 1, 1},
            {1, 1, 0, 0, 1},
            {1, 1, 1, 1, 1}
    };

    static boolean isValidMove(int x, int y, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1 && !visited[x][y];
    }

    public static void main(String[] args) {
        // 미로 탐색을 위한 BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[] {0, 0});  // 시작점 (0, 0)
        visited[0][0] = true;

        // 방향 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            // 목표 지점에 도달하면 종료
            if (x == N - 1 && y == N - 1) {
                System.out.println("목표에 도달했습니다!");
                return;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i], newY = y + dy[i];
                if (isValidMove(newX, newY, visited)) {
                    visited[newX][newY] = true;
                    queue.add(new int[] {newX, newY});
                }
            }
        }
        System.out.println("목표에 도달할 수 없습니다.");
    }
}
