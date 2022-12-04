package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ2178_미로탐색 {
    static int N, M;

    static class Node {
        int y, x;
        int level;

        public Node(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    static Queue<Node> queue = new LinkedList<>();
    static int answer;
    static char[][] map;
    static int[][] dydx = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        for (int y = 0; y < N; y++) {
            map[y] = br.readLine().toCharArray();
        }
        solution();
        System.out.println(answer);

    }

    static void solution() {
        queue.add(new Node(0, 0, 1));
        visit[0][0] = true;
        bfs();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dydx[i][0];
                int x = now.x + dydx[i][1];
                if (y < 0 || x < 0 || y >= N || x >= M || visit[y][x] || map[y][x] == '0') {
                    continue;
                }
                if (y == N - 1 && x == M - 1) {
                    answer = now.level + 1;
                    return;
                }
                visit[y][x] = true;
                queue.add(new Node(y, x, now.level + 1));
            }
        }
    }
}
