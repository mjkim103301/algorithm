package baekjoon.level_silver;

import java.util.*;
public class BOJ15652_N과M4 {
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
        permutation(0);
    }
    static void permutation(int level){
        if(level==M){
            for(int i=0;i<M;i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            if(level>0 && arr[level-1]>i) continue;
            arr[level]=i;
            permutation(level+1);
        }
    }
}
