package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ5430_AC {
    static int T, N;
    static String order;
    static Deque<Integer> map = new ArrayDeque<>();
    static boolean isStartFront;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            map.clear();
            isStartFront = true;
            order = br.readLine();
            N = Integer.parseInt(br.readLine());
            setDequeue(br.readLine());
            solution();
        }
        System.out.println(sb);
    }

    static void setDequeue(String input) {
        if (N <= 0) {
            return;
        }
        String number = "";
        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ',' || ch == ']') {
                map.add(Integer.parseInt(number));
                number = "";
            } else {
                number += ch;
            }
        }
    }

    static void solution() {
        for (int i = 0; i < order.length(); i++) {
            switch (order.charAt(i)) {
                case 'R': {
                    isStartFront = !isStartFront;
                    break;
                }
                case 'D': {
                    if (map.isEmpty()) {
                        sb.append("error\n");
                        return;
                    } else if (isStartFront) {
                        map.pollFirst();
                    } else {
                        map.pollLast();
                    }
                    break;
                }
                default:
                    break;
            }
        }
        int mapSize = map.size();
        if (mapSize == 0) {
            sb.append("[]\n");
            return;
        }
        sb.append("[");
        if (isStartFront) {
            for (int i = 0; i < mapSize - 1; i++) {
                sb.append(map.pollFirst() + ",");
            }
        } else {
            for (int i = 0; i < mapSize - 1; i++) {
                sb.append(map.pollLast() + ",");
            }
        }
        sb.append(map.poll()+"]\n");
    }
}
