package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ1062_가르침 {
    static int max;
    static int N, K;
    static boolean[] alphabet;
    static Set<Integer> teachSet = new HashSet<>();
    static List<String> wordList = new ArrayList<>();
    static int canTeach;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        alphabet = new boolean[26];
        init();
        canTeach = K - 5;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() > 8) {
                word = word.substring(4, word.length() - 4);
                addTeachSet(word);
                wordList.add(word);
            } else {
                wordList.add("");
            }

        }

        solution();
        System.out.println(max);

    }

    static void init() {
        alphabet['a' - 'a'] = true;
        alphabet['n' - 'a'] = true;
        alphabet['t' - 'a'] = true;
        alphabet['i' - 'a'] = true;
        alphabet['c' - 'a'] = true;
    }

    static void addTeachSet(String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (!alphabet[index]) {
                teachSet.add(word.charAt(i) - 'a');
            }
        }
    }

    static void solution() {
        if (canTeach < 0) {
            max = 0;
            return;
        } else if (canTeach >= teachSet.size()) {
            max = N;
            return;
        }

        List<Integer> learn = new ArrayList<>(teachSet);

        boolean[] used = new boolean[learn.size()];
        combination(0, 0, learn, used);
    }

    static void combination(int level, int next, List<Integer> learn, boolean[] used) {
        if (level == canTeach) {
            int canRead = getReadCnt();
            max = Math.max(canRead, max);
            return;
        }
        for (int i = next; i < learn.size(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            alphabet[learn.get(i)] = true;
            combination(level + 1, i + 1, learn, used);
            alphabet[learn.get(i)] = false;
            used[i] = false;
        }

    }

    static int getReadCnt() {
        int canReadCnt = 0;
        for (String item : wordList) {
            boolean canRead = true;
            for (int i = 0; i < item.length(); i++) {
                int index = item.charAt(i) - 'a';
                if (!alphabet[index]) {
                    canRead = false;
                    break;
                }
            }

            if (canRead) {
                canReadCnt++;
            }
        }
        return canReadCnt;
    }
}
