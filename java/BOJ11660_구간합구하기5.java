package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ11660_구간합구하기5 {
    static int N, M;
    static long[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new long[N + 1][N + 1];
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                map[y][x] = map[y][x - 1] + Integer.parseInt(st.nextToken());
            }
        }
        makeDP();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int minY = Integer.parseInt(st.nextToken());
            int minX = Integer.parseInt(st.nextToken());
            int maxY = Integer.parseInt(st.nextToken());
            int maxX = Integer.parseInt(st.nextToken());
            solution(minY, minX, maxY, maxX);
        }
        System.out.println(sb);
    }

    static void makeDP() {
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                map[y][x] += map[y - 1][x];
            }
        }
    }

    static void solution(int minY, int minX, int maxY, int maxX) {
        long answer = map[maxY][maxX] - map[maxY][minX - 1] - map[minY - 1][maxX] + map[minY - 1][minX - 1];
        sb.append(answer).append("\n");
    }
}
