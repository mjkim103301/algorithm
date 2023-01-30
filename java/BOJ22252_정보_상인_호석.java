package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ22252_정보_상인_호석 {
    static int Q;
    static Map<String, PriorityQueue<Integer>> map = new HashMap<>();
    static long valueSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            if (num == 1) {
                putValue(name, cnt, st);
            } else if (num == 2) {
                buyValue(name, cnt);

            }
        }
        System.out.print(valueSum);
    }

    static void putValue(String name, int cnt, StringTokenizer st) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if (map.containsKey(name)) {
            pq = map.get(name);
        }
        for (int i = 0; i < cnt; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        map.put(name, pq);
    }

    static void buyValue(String name, int cnt) {
        if (!map.containsKey(name)) {
            return;
        }

        PriorityQueue<Integer> pq = map.get(name);
        for (int i = 0; i < cnt; i++) {
            if (pq.isEmpty()) {
                break;
            }
            valueSum += pq.poll();
        }
    }
}
