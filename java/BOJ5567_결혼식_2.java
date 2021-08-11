package ssafy.algo.study.week08;

import java.io.*;
import java.util.*;

public class BOJ5567_결혼식_2 {
    static int N, M;
    static LinkedList<Integer>[] map;
    static int answer;
    static Set<Integer> friend = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new LinkedList<>();
        }

        // 인접 리스트 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            map[num1].add(num2);
            map[num2].add(num1);
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        Iterator<Integer> iter = map[1].iterator();
        while (iter.hasNext()) {
            invite(iter.next());
        }
        answer = friend.size() - 1; // 1도 friend에 포함됐기 때문에 1 제거
    }

    static void invite(int start) {
        Iterator<Integer> iter = map[start].iterator();
        friend.add(start); // 친구 저장
        while (iter.hasNext()) { // 친구의 친구 저장
            friend.add(iter.next());
        }
    }
}
