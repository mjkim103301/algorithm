package baekjoon.bronze;

import java.util.Scanner;

public class BOJ1259_팰린드롬수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            String num = scan.nextLine();
            if (num.equals("0")) {
                return;
            }
            StringBuffer sb = new StringBuffer(num);
            if (num.equals(sb.reverse().toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
