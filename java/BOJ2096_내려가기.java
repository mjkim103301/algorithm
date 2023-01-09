package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ2096_내려가기 {
    static int N;
    static int[][] map, minDp, maxDp;
    static int minScore, maxScore;
    static int[][] dydx = {
            {-1, 0},
            {-1, -1},
            {-1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        minDp = new int[N][3];
        maxDp = new int[N][3];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 3; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(maxScore + " " + minScore);
    }

    static void solution() {
        minDp[0] = Arrays.copyOf(map[0], 3);
        maxDp[0]=Arrays.copyOf(map[0], 3);
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < 3; x++) {
                minDp[y][x] = Integer.MAX_VALUE;
                for (int i = 0; i < 3; i++) {
                    int by = y + dydx[i][0];
                    int bx = x + dydx[i][1];
                    if (bx < 0 || bx >= 3) continue;
                    minDp[y][x] = Math.min(minDp[y][x], minDp[by][bx] + map[y][x]);
                    maxDp[y][x] = Math.max(maxDp[y][x], maxDp[by][bx] + map[y][x]);
                }

            }
        }

        minScore = Integer.MAX_VALUE;
        for (int x = 0; x < 3; x++) {
            minScore = Math.min(minScore, minDp[N - 1][x]);
            maxScore = Math.max(maxScore, maxDp[N - 1][x]);
        }
    }

}
