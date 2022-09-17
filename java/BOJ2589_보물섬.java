package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ2589_보물섬 {
    static int maxLength;
    static int H, W;
    static char[][] map;
    static int move[][] = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    static class Node {
        int y;
        int x;
        int level;

        public Node(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        for (int y = 0; y < H; y++) {
            String input = br.readLine();
            for (int x = 0; x < W; x++) {
                map[y][x] = input.charAt(x);
            }
        }

        solution();
        System.out.println(maxLength);
    }

    static void solution() {
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                if (map[y][x] == 'L') {
                    boolean[][] visit = new boolean[H][W];
                    visit[y][x] = true;
                    queue.add(new Node(y, x, 0));
                    bfs(visit);
                }
            }
        }
    }

    static void bfs(boolean[][] visit) {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if(now.level>maxLength){
                maxLength=now.level;
            }
            for (int i = 0; i < 4; i++) {
                int yy = now.y + move[i][0];
                int xx = now.x + move[i][1];

                if (yy < 0 || xx < 0 || yy >= H || xx >= W) {
                    continue;
                }
                if (map[yy][xx] == 'W' || visit[yy][xx]) {
                    continue;
                }
                visit[yy][xx] = true;
                queue.add(new Node(yy, xx, now.level+1));
            }
        }
    }
}
