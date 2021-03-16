package baekjoon.level_gold;

import java.util.*;

public class BOJ1759_암호만들기 {
    static int L, C;
    static char[] candidate;
    static boolean[] visited, vowel;
    static char[] code;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        L = scan.nextInt();
        C = scan.nextInt();

        code = new char[L];
        visited = new boolean[C];
        candidate = new char[C];
        vowel = new boolean[C];

        for (int i = 0; i < C; i++) {
            candidate[i] = scan.next().charAt(0);
        }

        solution();
    }

    static void solution() {
        Arrays.sort(candidate);
        for (int i = 0; i < C; i++) {
            char ch = candidate[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowel[i] = true;
            }
        }

        for (int i = 0; i <= C - L; i++) {
            dfs(0, i, 0, 0);
            visited = new boolean[C];
        }
    }

    static void dfs(int level, int now, int vowelCnt, int consonantCnt) {
        visited[now] = true;
        code[level] = candidate[now];
        if (vowel[now]) {
            vowelCnt++;
        } else {
            consonantCnt++;
        }

        if (level == L - 1) {
            if (vowelCnt >= 1 && consonantCnt >= 2) {
                for (int i = 0; i < L; i++) {
                    System.out.print(code[i]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = now + 1; i < C; i++) {
            dfs(level + 1, i, vowelCnt, consonantCnt);

        }
    }
}
