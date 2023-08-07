package baekjoon.bronze;

import java.util.*;
import java.io.*;

public class BOJ27433_팩토리얼2 {
    static int N;
    static long answer = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            answer *= i;
        }
        System.out.println(answer);
    }
}
