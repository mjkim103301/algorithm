package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ11286_절댓값_힙 {
    static int N;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!minHeap.isEmpty()) {
                    int key = minHeap.poll();
                    int value = map.get(key).poll();
                    sb.append(value + "\n");

                } else {
                    sb.append("0\n");
                }
            } else {
                int key = Math.abs(num);
                minHeap.add(key);
                if (!map.containsKey(key)) {
                    map.put(key, new PriorityQueue<>());
                }
                map.get(key).add(num);
            }
        }
        System.out.println(sb);
    }
}
