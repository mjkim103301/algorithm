package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ20444_색종이와_가위 {
    static long N, K; // N: 가위질 횟수, K: 만들어야 하는 색종이 조각 수 (int <= 2^31-1, long <= 2^63-1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        if (solution()) { //N번의 가위질로 K개의 색종이 조각을 만들수 있는지
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static boolean solution() {
        long left = 0; // 한 방향으로 자르는 최소 횟수
        long right = N / 2; // 한 방향으로 자르는 최대 휫수(가로, 세로 돌리면 똑같으니까)
        while (left <= right) {
            long row = (left + right) / 2; // 가로 방향으로 자르는 횟수
            long col = N - row; // 세로 방향으로 자르는 횟수
            long result = (row + 1) * (col + 1); // 만들어지는 색종이 조각 수
            if (result == K) {
                return true;
            } else if (result > K) { // 색종이 조각 수를 줄여야 하니까 row, col 차이를 늘려야 한다.(0과 가까워져야 한다.)
                right = row - 1;
            } else { // 색종이 조각 수를 늘려야 하니까 row, col 차이를 줄여야 한다. (mid = right에 가까워야 한다.)
                left = row + 1;
            }
        }
        return false;
    }
}
