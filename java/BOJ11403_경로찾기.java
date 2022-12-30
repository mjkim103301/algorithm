package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ11403_경로찾기 {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        System.out.print(sb);
    }

    static void solution() {
        floyd();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                sb.append(map[y][x]).append(" ");
            }
            sb.append("\n");
        }
    }

    static void floyd() {
        for (int k = 0; k < N; k++) {
            for (int from = 0; from < N; from++) {
                for (int to = 0; to < N; to++) {
                    if (k == from || k == to || map[from][to] == 1) continue;
                    if (map[from][k] == 1 && map[k][to] == 1) {
                        map[from][to] = 1;
                    }
                }
            }
        }
    }
}
