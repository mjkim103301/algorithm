package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978_소수찾기 {
    static int N;
    static int[] candidates;
    static int answer;

    static class Node {
        int num;
        boolean isPrimeNumber;

        public Node(int num, boolean isPrimeNumber) {
            this.num = num;
            this.isPrimeNumber = isPrimeNumber;
        }
    }

    static Node[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        candidates = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            candidates[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        setPrimeMap();
        countAnswer();
    }

    static void setPrimeMap() {
        map = new Node[1001];
        for (int i = 0; i < 1001; i++) {
            map[i] = new Node(i, true);
        }

        map[0].isPrimeNumber = false;
        map[1].isPrimeNumber = false;

        for (int i = 2; i < 1001; i++) {
            if (!isPrimeNumber(i)) {
                makeFalse(i);
            }
        }
    }

    static boolean isPrimeNumber(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void makeFalse(int num) {
        int i = 1;
        int target = num * i;
        while (target <= 1000) {
            map[target].isPrimeNumber = false;
            target = num * (++i);
        }

    }

    static void countAnswer() {
        for (int i = 0; i < N; i++) {
            if (map[candidates[i]].isPrimeNumber) {
                answer++;
            }
        }
    }
}
