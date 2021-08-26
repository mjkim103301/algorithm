package baekjoon.level_bronze;

import java.util.*;
import java.io.*;

public class BOJ1652_누울자리를찾아라 {
    static int N;
    static char[][]map;
    static int width,height;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        N=Integer.parseInt(br.readLine());
        map=new char[N][N];
        for(int y=0;y<N;y++){
            map[y]=br.readLine().toCharArray();
        }
        solution();

        System.out.print(width+" "+height);
    }

    static void solution(){
        for(int y=0;y<N;y++){
            int point=0;
            for(int x=0;x<N;x++){
                if(map[y][x]=='.'){
                    point++;
                }else if(map[y][x]=='X'){
                    if(point>=2){
                        width++;

                    }
                    point=0;
                }
            }
            if(point>=2){
                width++;
            }
        }

        for(int x=0;x<N;x++){
            int point=0;
            for(int y=0;y<N;y++){
                if(map[y][x]=='.'){
                    point++;
                }else if(map[y][x]=='X'){
                    if(point>=2){
                        height++;
                    }
                    point=0;
                }
            }
            if(point>=2){
                height++;
            }
        }
    }
}
