package baekjoon.level_bronze;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ2562_최댓값 {
    static Map<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = 0;
        for (int i = 1; i <= 9; i++) {
            int input = scan.nextInt();
            if (input > max) {
                max = input;
            }
            indexMap.put(input, i);
        }

        System.out.println(max);
        System.out.println(indexMap.get(max));
    }
}
