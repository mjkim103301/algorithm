package bundang.algo.study.week2;

import java.util.*;
import java.io.*;

public class BOJ16457_단풍잎이야기 {
    static int N, M, K;
    static int[][] skillMap;
    static int[] used;
    static int maxQuest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        skillMap = new int[M][K];
        used = new int[N];
        for (int y = 0; y < M; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < K; x++) {
                skillMap[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, 0);
        System.out.println(maxQuest);

    }

    static void solution(int level, int next) {
        if (level == N) {
            int passQuestCnt = getPassQuestCnt();
            if (passQuestCnt > maxQuest) {
                maxQuest = passQuestCnt;
            }
            return;
        }

        for (int i = next; i < 2 * N + 1; i++) {
            used[level] = i;
            solution(level + 1, i + 1);
        }
    }

    static int getPassQuestCnt() {
        Set<Integer> usedSet = new HashSet<>();
        int canPassCnt = 0;
        for (int usedKey : used) {
            usedSet.add(usedKey);
        }

        for (int y = 0; y < M; y++) {
            boolean canPass = false;
            for (int x = 0; x < K; x++) {
                if (!usedSet.contains(skillMap[y][x])) {
                    canPass = false;
                    break;
                }
                canPass = true;
            }

            if (canPass) {
                canPassCnt++;
            }
        }
        return canPassCnt;
    }
}
