package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ11651_좌표정렬하기2 {
    static int N;
    static int[][] points;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        points = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(sb);
    }

    static void solution() {
        Arrays.sort(points, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < 2; x++) {
                sb.append(points[y][x] + " ");
            }
            sb.append("\n");
        }
    }
}
