package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ1620_나는야_포켓몬_마스터_이다솜 {
    static HashMap<String, Integer> nameMap = new HashMap<>();
    static HashMap<Integer, String> numberMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            numberMap.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            if (nameMap.containsKey(target)) {
                sb.append(nameMap.get(target) + "\n");
            } else {
                sb.append(numberMap.get(Integer.parseInt(target)) + "\n");
            }
        }

        System.out.println(sb);
    }
}
