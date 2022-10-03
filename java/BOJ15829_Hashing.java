package baekjoon.bronze;


import java.util.Scanner;

public class BOJ15829_Hashing {
    static long[] multiply;
    static long mod = 1234567891;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int L = scan.nextInt();
        String input = scan.next();
        multiply = new long[51];
        init();
        long score = 0;

        for (int i = 0; i < L; i++) {
            score += ((input.charAt(i) - 'a' + 1) * multiply[i]) % mod;
        }
        System.out.println(score % mod);
    }

    static void init() {
        multiply[0] = 1;
        for (int i = 1; i <= 50; i++) {
            multiply[i] = multiply[i - 1] * 31 % mod;
        }
    }
}
