package codetree.gold;

import java.util.*;
import java.io.*;

public class 예술성 {
    static int N;
    static int[][] map, copy;
    static boolean[][] visit;

    static class Node {
        int color;
        List<int[]> location;

        public Node() {
            location = new ArrayList<>();
        }
    }

    static List<Node> groupList = new ArrayList<>();
    static Queue<int[]> queue = new LinkedList<>();
    static long scoreSum;
    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    static int[] candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];
        candidate = new int[2];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(scoreSum);
    }

    static void solution() {
        for (int i = 0; i < 4; i++) {
            groupList.clear();
            setGroup();
            addScore(0, 0);
            rotation();
        }
    }

    static void setGroup() {
        for (int y = 0; y < N; y++) {
            Arrays.fill(visit[y], false);
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visit[y][x]) {
                    bfs(y, x);
                }
            }
        }
    }

    static void bfs(int y, int x) {
        queue.clear();
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        int target = map[y][x];
        Node node = new Node();
        node.color = target;
        node.location.add(new int[]{y, x});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dydx[i][0];
                int nx = now[1] + dydx[i][1];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (visit[ny][nx] || map[ny][nx] != target) continue;
                visit[ny][nx] = true;
                queue.add(new int[]{ny, nx});
                node.location.add(new int[]{ny, nx});
            }
        }
        groupList.add(node);
    }

    static void addScore(int level, int start) {
        if (level == 2) {
            long score = getScore();
            scoreSum += score;
            return;
        }
        for (int i = start; i < groupList.size(); i++) {
            candidate[level] = i;
            addScore(level + 1, i + 1);
        }
    }

    static long getScore() {
        int index1 = candidate[0];
        int index2 = candidate[1];
        return (groupList.get(index1).location.size()
                + groupList.get(index2).location.size())
                * groupList.get(index1).color
                * groupList.get(index2).color
                * getMeetCnt();
    }

    static int getMeetCnt() {
        int cnt = 0;
        List<int[]> location1 = groupList.get(candidate[0]).location;
        List<int[]> location2 = groupList.get(candidate[1]).location;

        for (int[] now : location1) {
            for (int i = 0; i < 4; i++) {
                int y = now[0] + dydx[i][0];
                int x = now[1] + dydx[i][1];
                if (y < 0 || x < 0 || y >= N || x >= N) continue;
                for (int[] l2 : location2) {
                    if (l2[0] == y && l2[1] == x) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }


    static void rotation() {
        copy = new int[N][N];
        int midY = N / 2;
        int midX = N / 2;
        turnLeft(midY, midX);
        turnRight(0, midY - 1, 0, midX - 1);
        turnRight(0, midY - 1, midX + 1, N - 1);
        turnRight(midY + 1, N - 1, 0, midX - 1);
        turnRight(midY + 1, N - 1, midX + 1, N - 1);

        for (int y = 0; y < N; y++) {
            map[y] = Arrays.copyOf(copy[y], N);
        }
    }

    static void turnLeft(int midY, int midX) {
        for (int i = 0; i < N; i++) {
            copy[midY][i] = map[i][midX];
            copy[i][midX] = map[midY][N - 1 - i];
        }
    }

    static void turnRight(int minY, int maxY, int minX, int maxX) {
        int j=0;
        for (int y = minY; y <= maxY; y++) {
            int i=0;
            for (int x = minX; x <= maxX; x++) {
                copy[y][x] = map[maxY-(i++)][minX+j];
            }
            j++;
        }
    }

}
