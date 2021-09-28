package baekjoon.level_silver;

import java.util.*;
public class BOJ15651_N과M3 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        N=scan.nextInt();
        M=scan.nextInt();
        arr=new int[M];
        solution();
        System.out.println(sb);
    }

    static void solution(){
        combination(0);
    }

    static void combination(int level){
        if(level==M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            arr[level]=i;
            combination(level+1);
        }
    }

}
