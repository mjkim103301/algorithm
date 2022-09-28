package baekjoon.bronze;

import java.util.Scanner;

public class BOJ2775_부녀회장이_될테야 {
    static int T;
    static int K, N;
    static int[][] apart;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            K = scan.nextInt();
            N = scan.nextInt();
            apart = new int[K + 1][N + 1];
            solution();
            System.out.println(apart[K][N]);
        }
    }

    static void solution() {
        for (int x = 1; x <= N; x++) {
            apart[0][x] = x;
        }
        for (int y = 1; y <= K; y++) {
            for (int x = 1; x <= N; x++) {
                fillApart(y, x);
            }
        }
    }


    static void fillApart(int y, int x) {
        for (int w = 1; w <= x; w++) {
            apart[y][x] += apart[y - 1][w];
        }
    }
}
