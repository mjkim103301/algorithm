package baekjoon.silver;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ1074_Z_2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int answer = 0;
        BigInteger factorial = BigInteger.ONE;
        for (int i = N; i > 1; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        String result = factorial.toString();
        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) == '0') {
                answer++;
            } else {
                break;
            }
        }
        System.out.println(answer);

    }
}

