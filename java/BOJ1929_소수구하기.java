package baekjoon.silver;

import java.util.Scanner;

public class BOJ1929_소수구하기 {
    static int M, N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        M = scan.nextInt();
        N = scan.nextInt();
        for (int i = M; i <= N; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
