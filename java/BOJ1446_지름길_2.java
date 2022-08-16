package baekjoon.level_silver;

import java.io.*;
import java.util.*;
//dp
public class BOJ1446_지름길_2 {
    static int N, D;

    static class Node {
        int start;
        int end;
        int distance;

        public Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    static List<Node> shortcut;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortcut = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (start >= D || end > D || distance >= D || distance >= end - start) {
                continue;
            }
            shortcut.add(new Node(start, end, distance));
        }
        solution();
        System.out.println(dp[shortcut.size()][D]);

    }

    static void solution() {
        Collections.sort(shortcut, (Node a, Node b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            } else if (a.end != b.end) {
                return a.end - b.end;
            } else {
                return a.distance - b.distance;
            }
        });
        dp = new int[shortcut.size() + 1][D + 1];
        for (int x = 0; x <= D; x++) {
            dp[0][x] = x;
        }
        for (int y = 1; y <= shortcut.size(); y++) {
            for (int x = 0; x <= D; x++) {
                Node now = shortcut.get(y - 1);
                if (now.end > x) {
                    dp[y][x] = dp[y - 1][x];
                } else {

                    int left = dp[y][now.start];
                    int shortDistance = now.distance;
                    int right = x - now.end;
                    dp[y][x] = Math.min(left + shortDistance + right, dp[y - 1][x]);
                }
            }
        }


    }
}
