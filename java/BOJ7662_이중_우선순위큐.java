package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ7662_이중_우선순위큐 {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static Map<Integer, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int K = Integer.parseInt(br.readLine());
            minHeap.clear();
            maxHeap.clear();
            map.clear();
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                int number = Integer.parseInt(st.nextToken());
                solution(order, number);
            }
            printAnswer();
        }
        System.out.print(sb);
    }

    static void solution(char order, int number) {
        switch (order) {
            case 'I': {
                maxHeap.add(number);
                minHeap.add(number);
                if (map.containsKey(number)) {
                    map.put(number, map.get(number) + 1);
                } else {
                    map.put(number, 1);
                }
            }
            break;
            case 'D': {
                if (map.isEmpty() || minHeap.isEmpty() || maxHeap.isEmpty()) {
                    break;
                }
                int target = 0;
                if (number == 1) {
                    target = maxHeap.poll();
                    while (!map.containsKey(target)) {
                        target = maxHeap.poll();
                    }
                } else if (number == -1) {
                    target = minHeap.poll();
                    while (!map.containsKey(target)) {
                        target = minHeap.poll();
                    }
                }
                if (map.get(target) - 1 == 0) {
                    map.remove(target);
                } else {
                    map.put(target, map.get(target) - 1);
                }
            }
            break;
            default:
                break;
        }
    }

    static void printAnswer() {
        if (map.isEmpty() || minHeap.isEmpty() || maxHeap.isEmpty()) {
            sb.append("EMPTY\n");
        } else {
            int max = maxHeap.poll();
            while (!map.containsKey(max)) {
                max = maxHeap.poll();
            }
            int min = minHeap.poll();
            while (!map.containsKey(min)) {
                min = minHeap.poll();
            }
            sb.append(max + " ").append(min + "\n");
        }
    }
}
