package baekjoon.level_gold;

import java.util.*;

public class BOJ1300_K번째수 {
    static int N, K;
    static long answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        solution();
        System.out.println(answer);
        scan.close();
    }

    private static void solution() {
        long left = 1; //최솟값
        long right = (int) Math.pow(N, 2); //최댓값

        while (left <= right) {
            long mid = (left + right) / 2; //index를 구하려는 값
            long index = getIndex(mid); //mid의 index

            if (index < K) {
                left = mid + 1;

            } else if (index >= K) {
                //같은 수가 여러개 있을 경우 가장 뒤쪽의 index가 구해짐
                //그래서 answer에 mid값을 무조건 넣음
                answer = mid;
                right = mid - 1;
            }
        }
    }

    static long getIndex(long mid) {
        long index = 0;
        for (int i = 1; i <= N; i++) {
            long value = mid / i;
            index += (value <= N) ? value : N;
        }
        return index;
    }
}
