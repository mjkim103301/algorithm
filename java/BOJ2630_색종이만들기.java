package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ2630_색종이만들기 {
    static int N;
    static int[][] map;
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(answer[i]);
        }
    }

    static void solution() {
        answer[findPaper(0, 0, N, N)]++;
    }

    static int findPaper(int minY, int minX, int maxY, int maxX) {
        int target = map[minY][minX];
        boolean isSamePaper = true;
        for (int y = minY; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                if (target != map[y][x]) {
                    isSamePaper = false;
                    break;
                }
            }
            if (!isSamePaper) {
                break;
            }
        }
        if (!isSamePaper) {
            int diff = (maxY - minY) / 2;
            answer[findPaper(minY, minX, minY + diff, minX + diff)]++;
            answer[findPaper(minY, minX + diff, minY + diff, maxX)]++;
            answer[findPaper(minY + diff, minX, maxY, minX + diff)]++;
            answer[findPaper(minY + diff, minX + diff, maxY, maxX)]++;

            return 2;
        }
        return target;

    }
}
