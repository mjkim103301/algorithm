package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ1890_점프_2 {
    static int N;
    static int[][] map;
    static long[][] dp;
    static boolean[][] visit;
    static int[][] dydx = {
            {1, 0},
            {0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        visit = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(dp[0][0]);

    }

    static void solution() {
        dfs(0, 0);
    }

    static void dfs(int y, int x) {
        if (y == N - 1 && x == N - 1) {
            dp[y][x] = 1;
            return;
        }
        int distance = map[y][x];
        if (distance == 0) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            int yy = y + dydx[i][0] * distance;
            int xx = x + dydx[i][1] * distance;
            if (yy >= N || xx >= N) {
                continue;
            }
            if (visit[yy][xx]) {
                dp[y][x] += dp[yy][xx];
                continue;
            }
            dfs(yy, xx);
            dp[y][x] += dp[yy][xx];
        }
        visit[y][x] = true;
    }
}