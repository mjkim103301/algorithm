package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ11053_가장_긴_증가하는_부분수열 {
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
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        Arrays.fill(dp, 1);
        answer = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (map[i] > map[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
    }
}
