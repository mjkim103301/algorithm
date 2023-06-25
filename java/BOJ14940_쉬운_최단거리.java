package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ14940_쉬운_최단거리 {
    static int N, M;
    static int[][] map;
    static int[][] result;
    static boolean[][] visit;

    static class Node {
        int y, x;
        int level;

        public Node(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    static Node destination;
    static Queue<Node> queue = new LinkedList<>();

    static int[][] dydx = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];
        visit = new boolean[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 2) {
                    destination = new Node(y, x, 0);
                }
            }
        }
        solution();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if(!visit[y][x] && map[y][x]==1){
                    sb.append("-1").append(" ");
                }else{
                    sb.append(result[y][x]).append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void solution() {
        bfs(destination.y, destination.x);
    }

    static void bfs(int startY, int startX) {
        visit[startY][startX] = true;
        queue.add(new Node(startY, startX, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dydx[i][0];
                int x = now.x + dydx[i][1];
                if (y < 0 || x < 0 || y >= N || x >= M) continue;
                if (map[y][x] == 0 || visit[y][x]) continue;
                visit[y][x] = true;
                if (map[y][x] == 1) {
                    result[y][x] = now.level + 1;
                }
                queue.add(new Node(y, x, now.level + 1));
            }
        }
    }
}
