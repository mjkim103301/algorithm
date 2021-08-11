package baekjoon.level_gold;

import java.io.*;
import java.util.*;

public class BOJ2075_N번째큰수 {
    static int N;
    static int answer;
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                maxHeap.offer(Integer.parseInt(st.nextToken()));
            }
        }

        solution();
        System.out.print(answer);
    }

    static void solution() {
        // N-1 번째까지 max heap의 값을 버림
        for (int i = 0; i < N - 1; i++) {
            maxHeap.poll();
        }

        // N 번째 값을 answer에 저장
        answer = maxHeap.peek();
    }
}
