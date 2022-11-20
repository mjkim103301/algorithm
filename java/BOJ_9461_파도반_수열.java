package baekjoon.silver;

import java.util.Scanner;

public class BOJ_9461_파도반_수열 {
    static int N;
    static long[] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        dp();
        for (int i = 1; i <= T; i++) {
            N = scan.nextInt();
            sb.append(map[N] + "\n");
        }
        System.out.println(sb);

    }

    static void dp() {
        map = new long[101];
        map[1] = 1;
        map[2] = 1;
        map[3] = 1;
        map[4] = 2;
        map[5] = 2;
        for (int i = 6; i <= 100; i++) {
            map[i] = map[i - 1] + map[i - 5];
        }
    }
}
