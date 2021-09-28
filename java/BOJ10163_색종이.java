package baekjoon.level_bronze;

import java.util.*;
import java.io.*;

public class BOJ10163_색종이 {
    static int N;
    static int x,y,width,height;
    static int[][]map;
    static int[]area;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        map=new int[1002][1002];
        area=new int[N+1];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
            width=Integer.parseInt(st.nextToken());
            height=Integer.parseInt(st.nextToken());
            solution(i+1);
        }
        //print();

        for(int i=1;i<=N;i++){
            sb.append(area[i]+"\n");
        }
        System.out.println(sb);

    }
    static void solution(int id) {
        for (int yy = y; yy < y + height; yy++) {
            for (int xx = x; xx < x + width; xx++) {
                if (map[yy][xx] > 0) {
                    area[map[yy][xx]]--;
                }
                    map[yy][xx] = id;

                area[id]++;
            }
        }
    }

    static void print(){
        for (int yy = 0; yy < 50; yy++) {
            for (int xx = 0; xx <50; xx++) {
               System.out.print(map[yy][xx]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
