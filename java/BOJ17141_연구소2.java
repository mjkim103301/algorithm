package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ17141_연구소2 {
    static int N, M;
    static int[][] map;
    static boolean[][] visit;

    static class Node {
        int y, x;
        int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static int[] candidate;
    static List<Node> twos = new ArrayList<>();
    static int minTime = Integer.MAX_VALUE;
    static int canFillCnt;
    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new boolean[N][N];
        candidate = new int[M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] != 1) {
                    canFillCnt++;
                }
                if (map[y][x] == 2) {
                    twos.add(new Node(y, x, 0));
                }
            }
        }

        solution();
        if (minTime == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(minTime);
        }
    }

    static void solution() {
        combination(0, 0);
    }

    static void combination(int level, int start) {
        if (level == M) {
            int time = getTime();
            if (time >= 0) {
                minTime = Math.min(time, minTime);
            }
            clear();
            return;
        }
        for (int i = start; i < twos.size(); i++) {
            candidate[level] = i;
            combination(level + 1, i + 1);
        }
    }

    static void clear() {
        for (int y = 0; y < N; y++) {
            Arrays.fill(visit[y], false);
        }
    }

    static int getTime() {
        int time = -1;
        int cnt = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            Node item = twos.get(candidate[i]);
            queue.add(new Node(item.y, item.x, 0));
            visit[item.y][item.x] = true;
            cnt++;
        }
        if (cnt >= canFillCnt) {
            return 0;
        }
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dydx[i][0];
                int x = now.x + dydx[i][1];
                if (y < 0 || x < 0 || y >= N || x >= N) continue;
                if (map[y][x] == 1 || visit[y][x]) continue;
                visit[y][x] = true;
                queue.add(new Node(y, x, now.time + 1));
                cnt++;
                if (cnt >= canFillCnt) {
                    return now.time + 1;
                }
            }
        }
        return time;
    }
}
