package baekjoon.level_bronze;

import java.util.Scanner;

public class BOJ10809_알파벳 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print(input.indexOf(i) + " ");
        }
    }
}
