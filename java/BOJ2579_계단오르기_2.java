package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579_계단오르기_2 {
    static int N;
    static int[] stairs, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 3];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        solution();
        System.out.println(dp[0]);
    }

    static void solution() {
        dp[N + 2] = stairs[N];
        dp[N + 1] = stairs[N];
        dp[N] = stairs[N];
        if (N >= 2) {
            dp[N - 1] = stairs[N] + stairs[N - 1];
        }
        if (N >= 3) {
            dp[N - 2] = stairs[N] + stairs[N - 2];
        }

        for (int i = N - 3; i >= 1; i--) {
            dp[i] = Math.max(dp[i + 2] + stairs[i], dp[i + 3] + stairs[i + 1] + stairs[i]);
        }

        if (N > 1) {
            dp[0] = Math.max(dp[1], dp[2]);
        } else {
            dp[0] = dp[1];
        }
    }
}
