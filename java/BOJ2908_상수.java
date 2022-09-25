package baekjoon.level_bronze;

import java.util.Scanner;

public class BOJ2908_상수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String num1 = scan.next();
        String num2 = scan.next();
        int newNum1 = reverse(num1);
        int newNum2 = reverse(num2);
        if (newNum1 > newNum2) {
            System.out.println(newNum1);
        } else {
            System.out.println(newNum2);
        }
    }

    static int reverse(String target) {
        String result = "";
        for (int i = target.length() - 1; i >= 0; i--) {
            result += target.charAt(i);
        }
        return Integer.parseInt(result);
    }
}
