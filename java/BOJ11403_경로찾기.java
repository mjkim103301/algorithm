package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ11403_경로찾기 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            Arrays.fill(map[y], N + 1);
            for (int x = 0; x < N; x++) {
                if(Integer.parseInt(st.nextToken())==1){
                    map[y][x] = 1;
                }

            }
        }
        solution();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] <= N) {
                    System.out.print("1 ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    static void solution() {
        for(int k=0;k<N;k++){
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(map[y][x]>map[y][k]+map[k][x]){
                        map[y][x]=map[y][k]+map[k][x];
                    }
                }
            }
        }
    }
}
