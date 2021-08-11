package ssafy.algo.study.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5567_결혼식 {
    static int N, M;
    static LinkedList<Integer>[] map;
    static int answer;

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
        Set<Integer> friend = new HashSet<>(); // 1의 친구 저장
        Set<Integer> friendfriend = new HashSet<>(); //1의 친구의 친구 저장
        Iterator<Integer> iter = map[1].iterator();
        while (iter.hasNext()) {
            friend.add(iter.next());
        }

        Iterator<Integer> iter2 = friend.iterator();
        while (iter2.hasNext()) {
            iter = map[iter2.next()].iterator();
            while (iter.hasNext()) {
                friendfriend.add(iter.next());
            }
        }
        friend.addAll(friendfriend);
        answer = friend.size() - 1;
    }
}
