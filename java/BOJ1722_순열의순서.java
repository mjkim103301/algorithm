package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ1722_순열의순서 {
    static int N;
    static long K;
    static boolean[] used;
    static int[] arr;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        used = new boolean[N + 1];
        init();
        st = new StringTokenizer(br.readLine());
        int order = Integer.parseInt(st.nextToken());
        if (order == 1) {
            K = Long.parseLong(st.nextToken());
            getArr();
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            getK();
            System.out.println(K);
        }
    }

    static void init() {
        factorial = new long[N + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    static void getArr() {
        K--;
        for (int i = 0; i < N; i++) {
            int jump = 0;
            int fact = N - i - 1;

            if (K - factorial[fact] >= 0) {
                jump = (int) (K / factorial[fact]);
                K -= jump * factorial[fact];
            }

            setArr(i, jump);
        }
    }

    static void setArr(int index, int jump) {
        for (int i = 1; i < N + 1; i++) {
            if (used[i]) continue;
            if (jump == 0) {
                arr[index] = i;
                used[i] = true;
                return;
            }
            jump--;
        }
    }

    static void getK() {
        K++;
        for (int i = 0; i < N; i++) {
            int jump = getJump(i);
            K += jump * factorial[N - i - 1];
        }
    }

    static int getJump(int index) {
        int jump = 0;
        for (int i = 1; i <= N; i++) {
            if (used[i]) continue;
            if (i != arr[index]) {
                jump++;
            }else{
                used[i]=true;
                break;
            }
        }
        return jump;
    }
}
