package baekjoon.level_silver;

import java.util.*;
import java.io.*;

//플로이드 워셜
public class BOJ1058_친구 {
    static int N;
    static int[][] map;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];


        for (int y = 0; y < N; y++) {
            String input = br.readLine();
            Arrays.fill(map[y], 51);
            for (int x = 0; x < N; x++) {
                if (input.charAt(x) == 'Y') {
                    map[y][x] = 1;
                }
            }
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        for(int k=0;k<N;k++){
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(y==x)continue;
                    if(map[y][x]>map[y][k]+map[k][x]){
                        map[y][x]=map[y][k]+map[k][x];
                    }
                }
            }
        }

        for(int y=0;y<N;y++){
            int cnt=0;
            for(int x=0;x<N;x++){
                if(map[y][x]<=2 && map[y][x]>0){
                    cnt++;
                }
            }
            if(answer<cnt){
                answer=cnt;
            }
        }
    }
}
