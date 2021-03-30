package 백준특강;

import java.util.Scanner;

public class BOJ16922_로마숫자만들기_3 {
    static int N;
    static int[] roma = {1, 5, 10, 50};

    static int answer;
    static boolean[] num = new boolean[1001];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        solution();
        System.out.println(answer);
    }

    static void solution() {

        permutation(0, 0, 0);
    }

    static void permutation(int level, int start, int sum) {
        if (level == N) {
            if (!num[sum]) {
                num[sum] = true;
                answer++;
            }
            return;
        }
        for (int i = start; i < 4; i++) {
            permutation(level + 1, i, sum + roma[i]);
        }

    }
}
