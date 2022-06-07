package bundang.algo.study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15990_1_2_3더하기5_2 {
    static int T, N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        dp = new long[100_001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        solution();
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            long count = (dp[N][1] + dp[N][2] + dp[N][3]) % 1_000_000_009;
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    static void solution() {
        for (int y = 4; y < 100_001; y++) {
            dp[y][1] = (dp[y - 1][2] + dp[y - 1][3]) % 1_000_000_009;
            dp[y][2] = (dp[y - 2][1] + dp[y - 2][3]) % 1_000_000_009;
            dp[y][3] = (dp[y - 3][1] + dp[y - 3][2]) % 1_000_000_009;
        }
    }
}
