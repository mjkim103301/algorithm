package bundang.algo.study.week3;

import java.util.*;
import java.io.*;

public class BOJ1535_안녕 {
    static int N;

    static class Node {
        int power;
        int joy;

        public Node(int power, int joy) {
            this.power = power;
            this.joy = joy;
        }
    }

    static List<Node> people = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        people.add(new Node(0, 0));
        for (int i = 1; i <= N; i++) {
            people.add(new Node(Integer.parseInt(st.nextToken()), 0));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people.get(i).joy = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1][100];
        solution();
        System.out.println(dp[N][99]);
    }

    static void solution() {
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= 99; x++) {
                if (x < people.get(y).power) {
                    dp[y][x] = dp[y - 1][x];
                } else {
                    Node now = people.get(y);
                    dp[y][x] = Math.max(dp[y - 1][x], now.joy + dp[y - 1][x - now.power]);
                }
            }
        }
    }
}
