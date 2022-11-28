package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928_뱀과_사다리_게임 {
    static class Node {
        int location;
        int level;

        public Node(int location, int level) {
            this.location = location;
            this.level = level;
        }
    }

    static Map<Integer, Integer> map = new HashMap<>();
    static int answer;
    static Queue<Node> queue = new LinkedList<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[101];

        for (int i = 0, end = N + M; i < end; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        queue.add(new Node(1, 0));
        visit[1] = true;
        bfs();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int location = now.location + i;
                int level = now.level + 1;
                if (location == 100) {
                    answer = level;
                    return;
                } else if (location > 100 || visit[location]) {
                    continue;
                }
                visit[location] = true;
                if (map.containsKey(location)) {
                    queue.add(new Node(map.get(location), level));
                } else {
                    queue.add(new Node(location, level));
                }
            }
        }
    }
}
