package baekjoon.bronze;

import java.util.Scanner;

public class BOJ2231_분해합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int generator = 0;
        while (true) {
            String target = String.valueOf(generator);
            int test = 0;
            for (int i = 0; i < target.length(); i++) {
                test += target.charAt(i) - '0';
            }
            test += generator;
            if (n == test) {
                System.out.println(generator);
                return;
            } else if (generator >= 1000000) {
                System.out.println(0);
                return;
            }
            generator++;
        }

    }
}
