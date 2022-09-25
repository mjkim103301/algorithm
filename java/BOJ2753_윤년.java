package baekjoon.level_bronze;

import java.util.Scanner;

public class BOJ2753_윤년 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
