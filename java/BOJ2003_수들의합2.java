package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ2003_수들의합2 {
    static int N, M; //N: 수의 개수, M: 수의 합
    static int[] arr, accum; //arr: 입력된 수들이 저장된 배열, accum: 누적합
    static int cnt; //경우의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        accum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.print(cnt);
    }

    static void solution() {
        //누적합을 만듦
        accum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            accum[i] = accum[i - 1] + arr[i];
        }

        for (int i = 0; i < N; i++) {
            if (find(i)) {
                cnt++;
            }
        }
    }

    static boolean find(int i) {
        //누적합의 i 인덱스 값이 M 이면 return true;
        if (accum[i] == M) {
            return true;
        }

        //누적합의 i인덱스 값 - j 인덱스 값
        for (int j = 0; j < i; j++) {
            if (accum[i] - accum[j] == M) {
                return true;
            } else if (accum[i] - accum[j] < M) {
                return false;
            }
        }
        return false;
    }
}
