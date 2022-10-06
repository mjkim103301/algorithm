package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ1107_리모컨 {
    static class Node {
        int channel;
        int level;

        public Node(int channel, int level) {
            this.channel = channel;
            this.level = level;
        }
    }

    static int N, M;
    static boolean[] number;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        number = new boolean[10];
        Arrays.fill(number, true);
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                number[Integer.parseInt(st.nextToken())] = false;
            }
        }

        solution();
        System.out.println(answer);
    }

    static void solution() {
        Node now = new Node(100, 0);
        if (now.channel == N) {
            answer = 0;
            return;
        }
        answer = Math.abs(N - 100);
        minus(new Node(N, 0));
        plus(new Node(N, 0));

    }

    static void minus(Node now) {
        while (now.channel >= 0) {
            if (canMake(now.channel)) {
                answer = Math.min(answer, now.level + String.valueOf(now.channel).length());
                return;
            }
            now.channel--;
            now.level++;
        }
    }

    static void plus(Node now) {
        while (now.level < answer) {
            if (canMake(now.channel)) {
                answer = Math.min(answer, now.level + String.valueOf(now.channel).length());
                return;
            }
            now.channel++;
            now.level++;
        }
    }

    static boolean canMake(int channel) {
        String num = String.valueOf(channel);
        for (int i = 0; i < num.length(); i++) {
            int button = num.charAt(i) - '0';
            if (!number[button]) {
                return false;
            }
        }
        return true;
    }
}
