package baekjoon.gold;

import java.io.IOException;

import java.util.*;
import java.io.*;

public class BOJ2206_벽부수고_이동하기 {
    static int N, M;

    static class Node {
        int y, x;
        int level;
        boolean brokenWall;

        public Node(int y, int x, int level, boolean brokenWall) {
            this.y = y;
            this.x = x;
            this.level = level;
            this.brokenWall = brokenWall;
        }
    }

    static Queue<Node> queue = new LinkedList<>();
    static char[][] map;
    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static boolean[][] visit, brokenWallVisit;
    static int answer;
    static boolean isFinsih;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        brokenWallVisit = new boolean[N][M];
        for (int y = 0; y < N; y++) {
            map[y] = br.readLine().toCharArray();
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        if (N == 1 && M == 1) {
            answer = 1;
            return;
        }
        visit[0][0] = true;
        brokenWallVisit[0][0] = true;
        queue.add(new Node(0, 0, 1, false));
        bfs();
        if (!isFinsih) {
            answer = -1;
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dydx[i][0];
                int x = now.x + dydx[i][1];
                if (y < 0 || x < 0 || y >= N || x >= M) {
                    continue;
                }
                if (now.brokenWall && brokenWallVisit[y][x]) {
                    continue;
                }
                if (!now.brokenWall && visit[y][x]) {
                    continue;
                }
                if (y == N - 1 && x == M - 1) {
                    answer = now.level + 1;
                    isFinsih = true;
                    return;
                }
                if (map[y][x] == '1' && !now.brokenWall) {
                    brokenWallVisit[y][x] = true;
                    queue.add(new Node(y, x, now.level + 1, true));
                } else if (map[y][x] == '0') {
                    if (now.brokenWall) {
                        brokenWallVisit[y][x] = true;
                    } else {
                        visit[y][x] = true;
                    }
                    queue.add(new Node(y, x, now.level + 1, now.brokenWall));
                }
            }

        }
    }
}
