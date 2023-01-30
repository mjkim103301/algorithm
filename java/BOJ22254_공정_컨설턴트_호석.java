package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ22254_공정_컨설턴트_호석 {
    static int N, X;
    static int[] gifts;
    static int lineCnt;
    static int[] factory;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        gifts = new int[N];
        factory = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gifts[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.print(lineCnt);
    }

    static void solution() {
        int left = 1;
        int right = N;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canMakeUsingLines(mid)) {
                right = mid - 1;
                lineCnt = mid;
            } else {
                left = mid + 1;
            }
        }
    }

    static boolean canMakeUsingLines(int lines) {
        factory = new int[lines];
        pq.clear(); //0: factory 라인 번호, 1: 사이즈
        for (int i = 0; i < lines; i++) {
            pq.add(new int[]{i, 0});
        }

        for (int i = 0; i < N; i++) {
            int[] nextLine = pq.poll();
            factory[nextLine[0]] += gifts[i];
            if(factory[nextLine[0]]>X){
                return false;
            }
            pq.add(new int[]{nextLine[0], factory[nextLine[0]]});
        }
        return true;
    }
}
