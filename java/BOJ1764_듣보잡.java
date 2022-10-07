package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1764_듣보잡 {
    static int N, M;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            put(name);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            put(name);
        }

        solution();
        System.out.println(sb);

    }

    static void put(String name) {
        if (map.containsKey(name)) {
            map.put(name, map.get(name) + 1);
        } else {
            map.put(name, 1);
        }
    }

    static void solution() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);
        sb.append(answer.size() + "\n");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i) + "\n");
        }

    }
}
