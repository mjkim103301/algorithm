package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ6064_카잉달력 {
    static int M, N, X, Y;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            solution();
        }
        System.out.println(sb);
    }

    static void solution() {
        boolean isPossible = false;
        int year = -1;
        if (M < N) {
            for (int i = 0; i < M; i++) {
                year = i * N + Y;
                if (year % M == X % M) {
                    isPossible = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < N; i++) {
                year = i * M + X;
                if (year % N == Y % N) {
                    isPossible = true;
                    break;
                }
            }
        }

        if (isPossible) {
            sb.append(year + "\n");
        } else {
            sb.append("-1\n");
        }
    }
}
