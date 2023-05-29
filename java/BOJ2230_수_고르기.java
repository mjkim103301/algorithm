package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ2230_수_고르기 {
    static int N, M; // N: 정수 개수, M: 두 수의 최소 차이
    static int[] arr; // 수열
    static int minDiff = Integer.MAX_VALUE; // 답: 최소 차이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N]; // 수열의 개수를 정수 개수로 초기화
        for (int i = 0; i < N; i++) { // 수열 입력
            arr[i] = Integer.parseInt(br.readLine());
        }
        solution();
        System.out.println(minDiff); // 답 출력
    }

    static void solution() {
        Arrays.sort(arr); // 수열 정렬
        int left = 0; // 이분탐색 왼쪽 값
        int right = 0; // 이분탐색 오른쪽 값
        while (left <= right && left < N && right < N) { // 종료 조건
            int diff = arr[right] - arr[left]; // 두 수의 차이
            if (diff >= M) { // 두 수의 차이가 최소 차이 이상이면
                minDiff = Math.min(diff, minDiff); // 답을 최솟값으로 갱신
                if (diff == M) { // 두 수의 차이가 최소 차이면 그대로 출력
                    return;
                }
                left++; // 왼쪽 값 index 늘리기

            } else { // 두 수의 차이가 M 보다 작으면
                right++; // 오른쪽 값 index 늘리기
            }
        }
    }
}
