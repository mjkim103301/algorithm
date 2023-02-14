package baekjoon.gold;

import java.util.*;
import java.io.*;

//시간절약, 메모리절약
public class BOJ20437_문자열게임2_2 {
    static String W;
    static int K;
    static Map<Character, List<Integer>> indexMap = new HashMap<>();
    static int maxLength, minLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());
            maxLength = 0;
            minLength = Integer.MAX_VALUE;
            indexMap.clear();
            solution();
            if (minLength == Integer.MAX_VALUE) {
                sb.append("-1");
            } else {
                sb.append(minLength).append(" ").append(maxLength);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void solution() {
        for (int i = 0; i < W.length(); i++) {
            char key = W.charAt(i);
            if (indexMap.containsKey(key)) {
                indexMap.get(key).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indexMap.put(key, list);
            }
        }

        for (Map.Entry<Character, List<Integer>> item : indexMap.entrySet()) {
            List<Integer> indexList = item.getValue();
            for (int i = K - 1; i < indexList.size(); i++) {
                int diff = indexList.get(i) - indexList.get(i - (K - 1)) + 1;
                minLength = Math.min(minLength, diff);
                maxLength = Math.max(maxLength, diff);
            }
        }
    }
}
