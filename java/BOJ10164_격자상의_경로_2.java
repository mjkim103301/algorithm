package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ10164_격자상의_경로_2 {
    static int N, M, K;
    static int[][] dp;
    static int[][] dydx = {
            {0, 1},
            {1, 0}
    };

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();

        dp = new int[N][M];
        solution();
        System.out.println(dp[N - 1][M - 1]);
    }

    static void solution() {
        dp[0][0] = 1;
        if (K == 0) {
            runRobot(0, 0, N - 1, M - 1);
        } else {
            int ky = (K - 1) / M;
            int kx = (K - 1) % M;
            runRobot(0, 0, ky, kx);
            runRobot(ky, kx, N - 1, M - 1);
        }
    }

    static void runRobot(int minY, int minX, int maxY, int maxX) {
        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                for (int i = 0; i < 2; i++) {
                    int ny = y + dydx[i][0];
                    int nx = x + dydx[i][1];
                    if (ny > maxY || nx > maxX) continue;
                    dp[ny][nx] += dp[y][x];
                }
            }
        }
    }
}
