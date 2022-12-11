package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ11055_가장_큰_증가_부분수열 {
    static int N;
    static int[] map;
    static int[] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            dp[i] = map[i];
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        answer = dp[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (map[j] < map[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + map[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
    }
}
