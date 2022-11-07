package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ1780_종이의_개수 {
    static int N;
    static int[] answer = new int[4];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken(" "));
            }
        }
        solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(answer[i]);
        }


    }

    static void solution() {
        answer[checkPaper(0, 0, N, N)]++;
    }

    static int checkPaper(int minY, int minX, int maxY, int maxX) {
        int standard = map[minY][minX];
        boolean isSameData = true;
        for (int y = minY; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                if (map[y][x] != standard) {
                    isSameData = false;
                    break;
                }
            }
            if (!isSameData) {
                break;
            }
        }
        if (!isSameData) {
            int diff = (maxY - minY) / 3;
            answer[checkPaper(minY, minX, minY + diff, minX + diff)]++;
            answer[checkPaper(minY, minX + diff, minY + diff, minX + diff * 2)]++;
            answer[checkPaper(minY, minX + diff * 2, minY + diff, maxX)]++;
            answer[checkPaper(minY + diff, minX, minY + diff * 2, minX + diff)]++;
            answer[checkPaper(minY + diff, minX + diff, minY + diff * 2, minX + diff * 2)]++;
            answer[checkPaper(minY + diff, minX + diff * 2, minY + diff * 2, maxX)]++;
            answer[checkPaper(minY + diff * 2, minX, maxY, minX + diff)]++;
            answer[checkPaper(minY + diff * 2, minX + diff, maxY, minX + diff * 2)]++;
            answer[checkPaper(minY + diff * 2, minX + diff * 2, maxY, maxX)]++;
            return 3;
        }
        return standard + 1;
    }
}
