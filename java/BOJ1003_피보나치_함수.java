package baekjoon.silver;

import java.io.*;

public class BOJ1003_피보나치_함수 {
    static long[][] fibonacci;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        fibonacci = new long[41][2];
        init();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(fibonacci[n][0] + " ");
            sb.append(fibonacci[n][1] + "\n");
        }
        System.out.println(sb);
    }

    static void init() {
        fibonacci[0][0] = 1;
        fibonacci[0][1] = 0;
        fibonacci[1][0] = 0;
        fibonacci[1][1] = 1;

        for (int y = 2; y <= 40; y++) {
            fibonacci[y][0] = fibonacci[y - 1][0] + fibonacci[y - 2][0];
            fibonacci[y][1] = fibonacci[y - 1][1] + fibonacci[y - 2][1];
        }
    }
}
