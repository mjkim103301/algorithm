package ssafy.algo.study.week08;

import java.io.*;

public class BOJ2302_극장좌석 {
    static int N, M;
    static boolean[] vip;
    static int[] dp;
    static int answer = 1;
    static int MAX = 40;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        vip = new boolean[N + 1];
        dp = new int[MAX + 1];
        for (int i = 0; i < M; i++) {
            vip[Integer.parseInt(br.readLine())] = true;
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= MAX; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int cnt = 0; // 일반 좌석 개수
        for (int i = 1; i <= N; i++) {
            if (vip[i]) {
                answer *= dp[cnt];
                cnt = 0;
            } else {
                cnt++;
            }
        }

        // 마지막 좌석이 vip가 아니면 answer계산을 안하고 종료하므로 계산
        if (!vip[N]) {
            answer *= dp[cnt];
        }
    }
}
