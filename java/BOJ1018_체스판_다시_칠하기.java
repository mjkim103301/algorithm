package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018_체스판_다시_칠하기 {
    static int Y, X;
    static char[][] map;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new char[Y][X];
        for (int y = 0; y < Y; y++) {
            map[y] = br.readLine().toCharArray();
        }
        solution();
        System.out.println(min);
    }

    static void solution() {
        for (int y = 0; y <= Y - 8; y++) {
            for (int x = 0; x <= X - 8; x++) {
                makeBoard(y, y + 8, x, x + 8, 'B');
                makeBoard(y, y + 8, x, x + 8, 'W');
            }
        }

    }

    static void makeBoard(int minY, int maxY, int minX, int maxX, char start) {
        int changeCount = 0;
        for (int y = minY; y < maxY; y++) {
            for (int x = minX; x < maxX; x++) {
                if ((y + x) % 2 == 0 && map[y][x] == start) continue;
                if ((y + x) % 2 != 0 && map[y][x] != start) continue;
                changeCount++;
            }
        }
        if (changeCount < min) {
            min = changeCount;
        }
    }
}
