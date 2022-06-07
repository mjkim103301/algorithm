package bundang.algo.study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111_마인크래프트 {
    static int N, M, B;
    static int standardHeight, maxHeight;
    static int time, minTime = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        System.out.println(minTime + " " + maxHeight);
    }

    static void solution() {
        findMaxHeight();

        while (standardHeight >= 0) {
            int plus = 0;
            int minus = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] > standardHeight) {
                        minus += map[y][x] - standardHeight;
                    } else if (map[y][x] < standardHeight) {
                        plus += standardHeight - map[y][x];
                    }
                }
            }

            if (minus + B >= plus) {
                time = plus + minus * 2;
                if (minTime > time) {
                    minTime = time;
                    maxHeight = standardHeight;
                }

            }
            standardHeight--;

        }
    }

    static void findMaxHeight() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (standardHeight < map[y][x]) {
                    standardHeight = map[y][x];
                }
            }
        }
    }
}
