package baekjoon.silver;

import java.util.Scanner;

public class BOJ11866_요세푸스_문제_0 {
    static int N, K;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();

        used = new boolean[N + 1];
        solution();
        System.out.println(sb);
    }

    static void solution() {
        int count = 1;
        int out = 0;
        int index = 1;
        sb.append("<");
        while (out < N) {
            if (index > N) {
                index = 1;
            }
            if (used[index]) {
                index++;
                continue;
            }
            if (count == K) {
                out++;
                count = 1;
                sb.append(index + ", ");
                used[index] = true;
                continue;
            }
            count++;
            index++;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
    }
}
