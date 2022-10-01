package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ7568_덩치 {
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = 1;
        }
        solution();
        System.out.println(sb);
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            int[] now = map[i];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (now[0] > map[j][0] && now[1] > map[j][1]) {
                    map[j][2]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(map[i][2] + " ");
        }
    }
}
