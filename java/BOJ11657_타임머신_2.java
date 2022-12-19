package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ11657_타임머신_2 {
    static boolean isRepeated, isInfinite;
    static int N, M;
    static int[][] map;
    static boolean[][] canGo;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        canGo = new boolean[N + 1][N + 1];
        distance = new long[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (canGo[from][to] && map[from][to] < dist) {
                continue;
            }

            map[from][to] = dist;
            canGo[from][to] = true;

        }
        if (N == 1) {
            System.out.println("-1");
            return;
        }
        solution();
        StringBuilder sb = new StringBuilder();
        if (isInfinite) {
            sb.append("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    sb.append("-1");
                } else {
                    sb.append(distance[i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void solution() {
        Arrays.fill(distance, Integer.MAX_VALUE);
        int from = 1;
        distance[from] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bellmanFord(j);
            }
        }

        isRepeated = true;
        for (int i = 1; i <= N; i++) {
            if (isInfinite) return;
            bellmanFord(i);
        }
    }

    static void bellmanFord(int from) {
        if (distance[from] == Integer.MAX_VALUE) {
            return;
        }
        for (int to = 1; to <= N; to++) {
            if (!canGo[from][to] || from == to) {
                continue;
            }

            if (map[from][to] + distance[from] < distance[to]) {

                if (isRepeated) {
                    isInfinite = true;
                    return;
                }
                distance[to] = map[from][to] + distance[from];
            }
        }
    }
}