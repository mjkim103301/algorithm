package 백준특강;

import java.util.Scanner;

public class BOJ12904_A와B_2 {
    static StringBuilder S = new StringBuilder();
    static StringBuilder T = new StringBuilder();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        S.append(scan.next());
        T.append(scan.next());
        boolean result = solution(T);
        System.out.println(result ? 1 : 0);
    }

    static boolean solution(StringBuilder T) {
        while (S.length() < T.length()) {
            char last = T.charAt(T.length() - 1);
            T.deleteCharAt(T.length() - 1);
            if (last == 'B') {
                T.reverse();

            }
        }

        if (S.toString().equals(T.toString())) {
            return true;
        }
        return false;

    }
}
