package bundang.algo.study.week05;

import java.util.*;
import java.io.*;

public class BOJ15724_주지수 {
    static int N, M, K;
    static int[][] map;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new long[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        setDp();
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            sb.append(solution(y1, x1, y2, x2) + "\n");
        }
        System.out.println(sb);
    }

    static void setDp() {
        for (int y = 0; y < N; y++) {
            dp[y][0] = map[y][0];
            for (int x = 1; x < M; x++) {
                dp[y][x] = map[y][x] + dp[y][x - 1];
            }
        }
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                dp[y][x] += dp[y - 1][x];
            }
        }
    }

    static long solution(int y1, int x1, int y2, int x2) {
        long base = dp[y2][x2];
        long minusLeft = 0;
        long minusTop = 0;
        long plusLeftTop = 0;
        if (x1 > 0) {
            minusLeft = dp[y2][x1 - 1];
        }
        if (y1 > 0) {
            minusTop = dp[y1 - 1][x2];
        }
        if (x1 > 0 && y1 > 0) {
            plusLeftTop = dp[y1 - 1][x1 - 1];
        }
        return base - minusLeft - minusTop + plusLeftTop;
    }
}
