package baekjoon.gold;

import java.util.*;

public class BOJ13549_숨바꼭질3 {
    static int N, K;

    static class Node implements Comparable<Node> {
        int location;
        int time;

        public Node(int location, int time) {
            this.location = location;
            this.time = time;
        }


        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
    static boolean[] visit;
    static final int MAX = 100_000;
    static int answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        visit = new boolean[100_001];
        solution();
        System.out.println(answer);
    }

    static void solution() {
        priorityQueue.add(new Node(N, 0));
        bfs();
    }

    static void bfs() {
        while (!priorityQueue.isEmpty()) {
            Node now = priorityQueue.poll();
            visit[now.location] = true;
            if (now.location == K) {
                answer = now.time;
                break;
            }

            if (now.location * 2 <= MAX && !visit[now.location * 2]) {
                priorityQueue.add(new Node(now.location * 2, now.time));
            }
            if (now.location - 1 >= 0 && !visit[now.location - 1]) {
                priorityQueue.add(new Node(now.location - 1, now.time + 1));
            }
            if (now.location + 1 <= MAX && !visit[now.location + 1]) {
                priorityQueue.add(new Node(now.location + 1, now.time + 1));
            }
        }
    }

}
