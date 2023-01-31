package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ13422_도둑 {
    static int N, M, K;
    static int[] houses;
    static int cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cnt = 0;
            houses = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                houses[i] = Integer.parseInt(st.nextToken());
            }
            solution();
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void solution() {
        int money = init();
        if (N == M) {
            addCnt(money);
            return;
        }
        for (int i = M; i < N + M - 1; i++) {
            addCnt(money);
            int add = i;
            if (add >= N) {
                add -= N;
            }
            int delete = add - M;
            if (delete < 0) {
                delete += N;
            }
            money += houses[add];
            money -= houses[delete];

        }
        addCnt(money);

    }

    static void addCnt(int money) {
        if (money < K) {
            cnt++;
        }
    }

    static int init() {
        int value = 0;
        for (int i = 0; i < M; i++) {
            value += houses[i];
        }
        return value;
    }
}
