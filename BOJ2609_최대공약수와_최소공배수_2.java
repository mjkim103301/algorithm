package baekjoon.bronze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//유클리드 호제법을 이용해서 최대공약수, 최소공배수 구하기
public class BOJ2609_최대공약수와_최소공배수_2 {
    static int num1, num2;
    static int maxPrimeNumber, minMultipleNumber;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        num1 = scan.nextInt();
        num2 = scan.nextInt();
        solution();
        System.out.println(maxPrimeNumber);
        System.out.println(minMultipleNumber);
    }

    static void solution() {
        setMaxPrimeNumber();
        setMinMultipleNumber();
    }

    static void setMaxPrimeNumber() {
        if (num1 > num2) {
            gcb(num1, num2);
        } else {
            gcb(num2, num1);
        }
    }

    static void gcb(int n1, int n2) {
        if (n2 == 0) {
            maxPrimeNumber = n1;
            return;
        }
        gcb(n2, n1 % n2);

    }

    static void setMinMultipleNumber() {
        minMultipleNumber = num1 * num2 / maxPrimeNumber;
    }
}
