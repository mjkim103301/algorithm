package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ11149_RGB거리 {
    static int N;
    static int[][] dp, map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        map = new int[N][3];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 3; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(answer);

    }

    static void solution() {
        for (int x = 0; x < 3; x++) {
            dp[0][x] = map[0][x];
        }

        for (int y = 1; y < N; y++) {
            dp[y][0] = Math.min(dp[y - 1][1] + map[y][0], dp[y - 1][2] + map[y][0]);
            dp[y][1] = Math.min(dp[y - 1][0] + map[y][1], dp[y - 1][2] + map[y][1]);
            dp[y][2] = Math.min(dp[y - 1][0] + map[y][2], dp[y - 1][1] + map[y][2]);
        }
        answer = Math.min(dp[N - 1][0], dp[N - 1][1]);
        answer = Math.min(answer, dp[N - 1][2]);

    }
}
