package baekjoon.level_silver;

import java.io.*;
import java.util.*;

public class BOJ1446_지름길 {
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
    static int minDistance = Integer.MAX_VALUE;

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
        System.out.println(minDistance);

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

        boolean[] use = new boolean[shortcut.size()];
        Arrays.fill(use, false);
        subset(0, use);


    }

    static void subset(int level, boolean[] use) {
        if (level == shortcut.size()) {
            int distance = getDistance(use);
            if (distance < minDistance) {

                minDistance = distance;
            }
            return;
        }
        use[level] = true;
        subset(level + 1, use);
        use[level] = false;
        subset(level + 1, use);

    }

    static int getDistance(boolean[] use) {
        int position = 0;
        int distance = 0;
        for (int i = 0; i < shortcut.size(); i++) {
            if (!use[i]) {
                continue;
            }
            Node now = shortcut.get(i);
            if (now.start > position) {
                distance += (now.start - position);
            } else if (now.start < position) {
                return Integer.MAX_VALUE;
            }
            position = now.end;
            distance += now.distance;

        }
        if (D - position > 0) {
            distance += D - position;
        }
        return distance;
    }
}
