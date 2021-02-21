package baekjoon.level_gold;

import java.util.*;
import java.io.*;

public class BOJ13975_파일합치기3 {
    static int N;
    static PriorityQueue<Long> minHeap = new PriorityQueue<>();
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                minHeap.offer(Long.parseLong(st.nextToken()));
            }

            answer = 0;
            solution();
            sb.append(answer + "\n");
        }
        System.out.print(sb);

    }

    static void solution() {

        long sum = 0;
        while (!minHeap.isEmpty()) {
            long top = minHeap.poll();
            if (minHeap.isEmpty()) {
                answer = sum;
                return;
            }
            top += minHeap.poll();
            sum += top;
            minHeap.offer(top);
        }
    }
}
