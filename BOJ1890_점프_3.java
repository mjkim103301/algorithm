package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ1890_점프_3 {
    static int N;
    static int[][] map;
    static long[][] dp;
    static int[][] dydx = {
            {0, 1},
            {1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(dp[N - 1][N - 1]);

    }

    static void solution() {
        dp[0][0] = 1;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (dp[y][x] == 0 || map[y][x] == 0) continue;
                for (int i = 0; i < 2; i++) {
                    int yy = y + dydx[i][0] * map[y][x];
                    int xx = x + dydx[i][1] * map[y][x];
                    if (yy >= N || xx >= N) continue;
                    dp[yy][xx] += dp[y][x];
                }

            }
        }
    }
}
