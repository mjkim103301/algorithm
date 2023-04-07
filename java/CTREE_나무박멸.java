package codetree.gold;

import java.util.*;
import java.io.*;

public class CTREE_나무박멸 {
    static int N, M, K, C;
    static long deletedTreeCnt;

    static class Node {
        int tree;
        int deleteYear;

        public Node() {
        }
    }

    static Node[][] map, copyMap;
    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };
    static int[][] dydx2 = {
            {-1, 1},
            {1, 1},
            {1, -1},
            {-1, -1},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new Node[N][N];
        copyMap = new Node[N][N];

        init();
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int tree = Integer.parseInt(st.nextToken());
                map[y][x].tree = tree;
            }
        }
        solution();
        System.out.println(deletedTreeCnt);

    }

    static void init() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = new Node();
                copyMap[y][x] = new Node();
            }
        }
    }

    static void solution() {
        for (int year = 1; year <= M; year++) {
            grow();
            spread();
            delete();
        }
    }

    static void grow() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x].tree > 0) {
                    int cnt = getTreeCnt(y, x);
                    map[y][x].tree += cnt;
                }
            }
        }
    }

    static int getTreeCnt(int startY, int startX) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int y = startY + dydx[i][0];
            int x = startX + dydx[i][1];
            if (y < 0 || x < 0 || y >= N || x >= N) continue;
            if (map[y][x].tree > 0) {
                cnt++;
            }
        }
        return cnt;
    }

    static void spread() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x].tree > 0) {
                    plantNewTree(y, x);
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (copyMap[y][x].tree > 0) {
                    map[y][x].tree = copyMap[y][x].tree;
                    copyMap[y][x].tree = 0;
                }
            }
        }
    }

    static void plantNewTree(int startY, int startX) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int y = startY + dydx[i][0];
            int x = startX + dydx[i][1];
            if (y < 0 || x < 0 || y >= N || x >= N) continue;
            if (map[y][x].tree == 0 && map[y][x].deleteYear == 0) {
                cnt++;
            }
        }
        if(cnt==0){
            return;
        }
        int newTree = map[startY][startX].tree / cnt;
        for (int i = 0; i < 4; i++) {
            int y = startY + dydx[i][0];
            int x = startX + dydx[i][1];
            if (y < 0 || x < 0 || y >= N || x >= N) continue;
            if (map[y][x].tree == 0 && map[y][x].deleteYear == 0) {
                copyMap[y][x].tree += newTree;
            }
        }
    }

    static void delete() {
        int maxDelete = 0;
        int maxY = 0;
        int maxX = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x].tree > 0) {
                    int canDeleteCnt = getDeleteCnt(y, x);
                    if (maxDelete < canDeleteCnt) {
                        maxDelete = canDeleteCnt;
                        maxY = y;
                        maxX = x;
                    }
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x].deleteYear > 0) {
                    map[y][x].deleteYear--;
                }
            }
        }

        if(maxDelete==0){
            return;
        }
        map[maxY][maxX].deleteYear = C;
        deletedTreeCnt += map[maxY][maxX].tree;
        map[maxY][maxX].tree = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= K; j++) {
                int y = maxY + dydx2[i][0] * j;
                int x = maxX + dydx2[i][1] * j;
                if (y < 0 || x < 0 || y >= N || x >= N) continue;
                if (map[y][x].tree > 0) {
                    deletedTreeCnt += map[y][x].tree;
                    map[y][x].tree = 0;
                    map[y][x].deleteYear = C;
                } else {
                    map[y][x].deleteYear = C;
                    break;
                }
            }
        }
    }

    static int getDeleteCnt(int startY, int startX) {
        int cnt = map[startY][startX].tree;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= K; j++) {
                int y = startY + dydx2[i][0] * j;
                int x = startX + dydx2[i][1] * j;
                if (y < 0 || x < 0 || y >= N || x >= N) continue;
                if (map[y][x].tree > 0) {
                    cnt += map[y][x].tree;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }
}
