package baekjoon.bronze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ4153_직각삼각형 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            int num3 = scan.nextInt();
            if (num1 == 0 && num2 == 0 && num3 == 0) {
                return;
            }
            if (solution(num1, num2, num3)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }

    static boolean solution(int num1, int num2, int num3) {
        List<Integer> side = new ArrayList<>();
        side.add((int) Math.pow(num1, 2));
        side.add((int) Math.pow(num2, 2));
        side.add((int) Math.pow(num3, 2));
        Collections.sort(side);

        return side.get(0) + side.get(1) == side.get(2);
    }
}
