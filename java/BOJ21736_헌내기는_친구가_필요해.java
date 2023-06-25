package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ21736_헌내기는_친구가_필요해 {
    static int N, M;
    static char[][] map;
    static int answer;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Node doyeon;
    static boolean[][] visit;
    static int[][] dydx = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

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
        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.print(answer);
        }
    }

    static void solution() {
        findDoyeon();
        bfs();
    }

    static void findDoyeon() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] == 'I') {
                    doyeon = new Node(y, x);
                    return;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(doyeon);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dydx[i][0];
                int x = now.x + dydx[i][1];
                if (y < 0 || x < 0 || y >= N || x >= M || map[y][x] == 'X') continue;
                if (visit[y][x]) continue;
                visit[y][x] = true;
                queue.add(new Node(y, x));
                if (map[y][x] == 'P') {
                    answer++;
                }

            }
        }
    }
}
