package baekjoon.gold;

import java.util.*;

public class BOJ22251_빌런호석 {
    static int N, K, P, X;
    static boolean[][] num;
    static boolean[][] nowFloor;
    static int cnt, maxFloor;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        P = scan.nextInt();
        X = scan.nextInt();

        num = new boolean[10][7];
        initNum();
        initNowFloor();
        maxFloor = N;
        solution();
        System.out.println(cnt - 1);
    }

    static void initNum() {
        num[0] = new boolean[]{true, true, true, true, true, true, false};
        num[1] = new boolean[]{true, true, false, false, false, false, false};
        num[2] = new boolean[]{true, false, true, true, false, true, true};
        num[3] = new boolean[]{true, true, true, false, false, true, true};
        num[4] = new boolean[]{true, true, false, false, true, false, true};
        num[5] = new boolean[]{false, true, true, false, true, true, true};
        num[6] = new boolean[]{false, true, true, true, true, true, true};
        num[7] = new boolean[]{true, true, false, false, false, true, false};
        num[8] = new boolean[]{true, true, true, true, true, true, true};
        num[9] = new boolean[]{true, true, true, false, true, true, true};
    }

    static void initNowFloor() {
        nowFloor = new boolean[K][7];
        int floor = X;

        for (int i = 0; i < K; i++) {
            int n = floor;
            int divide = (int) Math.pow(10, K - i - 1);
            if (divide > 1) {
                n = floor / divide;
            }
            nowFloor[i] = Arrays.copyOf(num[n], 7);
            floor = floor % divide;
        }
    }

    static void solution() {
        for (int floor = 1; floor <= maxFloor; floor++) {
            if (canMake(floor)) {
                cnt++;
            }
        }
    }

    static boolean canMake(int floor) {
        int reverse = P;
        for (int i = 0; i < K; i++) {
            int divide = (int) Math.pow(10, K - i - 1);
            int n = floor / divide;
            int change = getChangeCnt(nowFloor[i], num[n]);
            reverse -= change;
            if (reverse < 0) {
                return false;
            }
            floor = floor % divide;
        }
        return true;

    }

    static int getChangeCnt(boolean[] from, boolean[] to) {
        int changeCnt = 0;
        for (int i = 0; i < 7; i++) {
            if (from[i] != to[i]) {
                changeCnt++;
            }
        }
        return changeCnt;
    }
}
