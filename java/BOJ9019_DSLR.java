package baekjoon.gold;

import java.io.*;
import java.util.*;

public class BOJ9019_DSLR {
    static class Node {
        int num;
        String order;

        public Node(int num, String order) {
            this.num = num;
            this.order = order;
        }
    }

    static StringBuilder sb = new StringBuilder();
    static Queue<Node> queue = new LinkedList<>();
    static Set<Integer> used = new HashSet<>();
    static String order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            queue.clear();
            used.clear();
            solution(A, B);
        }
        System.out.println(sb);
    }

    static void solution(int start, int target) {
        if (start == target) {
            sb.append("\n");
            return;
        }
        used.add(start);
        queue.add(new Node(start, ""));
        bfs(target);
        sb.append(order).append("\n");
    }

    static void bfs(int target) {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            Node update = runD(now);
            if (isStop(update.num, target)) {
                order=update.order;
                return;
            }
            addVisit(update);

            update = runS(now);
            if (isStop(update.num, target)) {
                order=update.order;
                return;
            }
            addVisit(update);
            update = runL(now);
            if (isStop(update.num, target)) {
                order=update.order;
                return;
            }
            addVisit(update);
            update = runR(now);
            if (isStop(update.num, target)) {
                order=update.order;
                return;
            }
            addVisit(update);
        }
    }

    static void addVisit(Node update){
        if(!used.contains(update.num)){
            used.add(update.num);
            queue.add(update);
        }
    }

    static boolean isStop(int updateNum, int target) {
        return updateNum == target;
    }

    static Node runD(Node now) {
        int num = now.num * 2 % 10000;
        return new Node(num, now.order + "D");
    }

    static Node runS(Node now) {
        int num = now.num - 1;
        if (num < 0) {
            num = 9999;
        }
        return new Node(num, now.order + "S");
    }

    static Node runL(Node now) {
        int first = now.num / 1000;
        int temp = now.num % 1000;
        int num = temp * 10 + first;
        return new Node(num, now.order + "L");
    }

    static Node runR(Node now) {
        int last = now.num % 10;
        int temp = now.num / 10;
        int num = last * 1000 + temp;
        return new Node(num, now.order + "R");
    }
}
