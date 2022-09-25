package baekjoon.level_bronze;

import java.util.Scanner;

public class BOJ3052_나머지 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean[] remains = new boolean[42];
        for (int i = 0; i < 10; i++) {
            remains[scan.nextInt() % 42] = true;
        }
        int count = 0;
        for (int i = 0; i < 42; i++) {
            if (remains[i]) {
                count++;
            }
        }
        System.out.println(count);

    }
}
