package baekjoon.level_gold;

import java.util.*;
import java.io.*;

public class BOJ1477_휴게소세우기_2 {
    static int N, M, L;
    static List<Integer> restRoom;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        restRoom = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            restRoom.add(Integer.parseInt(st.nextToken()));
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        long left = 1;
        long right = L - 1;
        restRoom.add(0);
        restRoom.add(L);
        Collections.sort(restRoom);
        while (left <= right) {
            long mid = (left + right) / 2;
            int count = canMake(mid);
            if (count > M) {
                left = mid + 1;
            } else {
                answer = (int) mid;
                right = mid - 1;
            }
        }
    }

    static int canMake(long distance) {
        int count = 0;
        for(int i=0;i<restRoom.size()-1;i++){
            count+=(restRoom.get(i+1)-restRoom.get(i)-1)/distance;
        }
        return count;
    }
}
