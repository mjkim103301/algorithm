package baekjoon.gold;

import java.util.*;

public class BOJ12851_숨바꼭질2 {
    static int N, K;

    static class Node {
        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    static boolean[] visit;
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
    static int minTime = Integer.MAX_VALUE;
    static int cnt;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        visit = new boolean[100_001];
        solution();
        System.out.println(minTime);
        System.out.print(cnt);
    }

    static void solution() {
        pq.add(new Node(N, 0));
        bfs();
    }

    static void bfs() {
        boolean find = false;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visit[now.position] = true;
            if (minTime < now.time) {
                continue;
            }
            if (now.position == K && !find) {
                minTime = now.time;
                find = true;
                cnt++;
            } else if (now.position == K && find && minTime == now.time) {
                cnt++;
            }

            int nextPosition = now.position * 2;
            if (nextPosition <= 100_000 && !visit[nextPosition]) {
                pq.add(new Node(nextPosition, now.time + 1));
            }
            nextPosition = now.position + 1;
            if (nextPosition <= 100_000 && !visit[nextPosition]) {
                pq.add(new Node(nextPosition, now.time + 1));
            }
            nextPosition = now.position - 1;
            if (nextPosition >= 0 && !visit[nextPosition]) {
                pq.add(new Node(nextPosition, now.time + 1));
            }
        }
    }
}
