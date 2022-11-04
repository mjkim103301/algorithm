package baekjoon.silver;

import org.w3c.dom.Node;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BOJ1697_숨바꼭질 {
    static class Node {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    static Queue<Node> queue = new ArrayDeque<>();
    static Set<Integer> set = new HashSet<>();
    static int N, K, answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        solution();
        System.out.println(answer);
    }

    static void solution() {
        if (N == K) {
            return;
        }
        bfs();
    }

    static void bfs() {
        queue.add(new Node(N, 0));
        set.add(N);
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.num + 1 == K || now.num - 1 == K || now.num * 2 == K) {
                answer = now.time + 1;
                return;
            }
            int next = now.num + 1;
            addNext(next, now.time + 1);
            next = now.num - 1;
            addNext(next, now.time + 1);
            next = now.num * 2;
            addNext(next, now.time + 1);
        }
    }

    static void addNext(int nextNum, int nextTime) {
        if (!set.contains(nextNum) && nextNum >= 0 && nextNum <= 100_000) {
            set.add(nextNum);
            queue.add(new Node(nextNum, nextTime));
        }
    }
}
