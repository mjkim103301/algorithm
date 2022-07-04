package bundang.algo.study.week04;

import java.util.*;
import java.io.*;

public class BOJ15686_치킨배달 {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static List<Node> home = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();
    static int[] used;
    static int N, M;
    static int minChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new int[M];


        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int map = Integer.parseInt(st.nextToken());
                if (map == 1) {
                    home.add(new Node(y, x));
                } else if (map == 2) {
                    chicken.add(new Node(y, x));
                }
            }
        }
        solution();
        System.out.println(minChickenDistance);
    }

    static void solution() {
        combination(0, 0);
    }

    static void combination(int level, int next) {
        if (level == M) {
            int chickenDistance = getChickenDistance();
            minChickenDistance = Math.min(chickenDistance, minChickenDistance);
            return;
        }
        for (int i = next; i < chicken.size(); i++) {
            used[level] = i;
            combination(level + 1, i + 1);
        }
    }

    static int getChickenDistance() {
        int chickenDistance = 0;
        for (Node nowHome : home) {
            int tempDistance = Integer.MAX_VALUE;
            for (int index : used) {
                Node nowChicken = chicken.get(index);
                tempDistance = Math.min(tempDistance, Math.abs(nowHome.y - nowChicken.y) + Math.abs(nowHome.x - nowChicken.x));
            }
            chickenDistance += tempDistance;
        }
        return chickenDistance;
    }
}
