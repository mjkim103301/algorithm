package baekjoon.gold;

import java.util.*;

public class BOJ16438_원숭이_스포츠 {
    static int N;
    static char[][] map;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder compare=new StringBuilder();
        N = scan.nextInt();
        map = new char[7][N];
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = 'A';
            }
        }
        for(int x=0;x<N;x++){
            compare.append('A');
        }
        solution();
        for (int y = 0; y < 7; y++) {
            String output=new String(map[y]);
            if(output.equals(compare.toString())){
                map[y][N-1]='B';
            }
            output=new String(map[y]);
            System.out.println(output);
        }
    }

    static void solution() {
        divideConquer(0, 0, N - 1);
    }

    static void divideConquer(int level, int start, int end) {
        if (level == 7) {
            return;
        }

        int mid = (start + end) / 2;
        for (int i = mid + 1; i <= end; i++) {
            map[level][i] = 'B';
        }
        divideConquer(level + 1, start, mid);
        divideConquer(level + 1, mid + 1, end);
    }
}
