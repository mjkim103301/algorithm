package baekjoon.level_gold;

import java.util.*;
import java.io.*;

public class BOJ2110_공유기설치 {
    static int N, C;
    static int[] position;
    static int maxPosition, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        position = new int[N];
        for (int i = 0; i < N; i++) {
            position[i] = Integer.parseInt(br.readLine());
            if (maxPosition < position[i]) {
                maxPosition = position[i];
            }
        }
        solution();
        System.out.println(answer);

    }

    static void solution() {
        long left = 1;
        long right = maxPosition - 1;
        Arrays.sort(position);
        while (left <= right) {
            long mid = (left + right) / 2;

            int count = canMake(mid);
            if (count >= C) {
                answer = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    static int canMake(long distance) {
        int count=1;
        int lastPosition=position[0];
        for (int i = 1; i < N; i++) {
            if(position[i]-lastPosition>=distance){
                lastPosition=position[i];
                count++;
            }
        }
        return count;
    }
}
