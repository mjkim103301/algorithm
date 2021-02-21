package baekjoon.level_silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15657_N과M8 {
    static int N,M;
    static int[] arr;
    static int[] pick;
    static StringBuilder sb=new StringBuilder();
    static void combination(int now, int index){
        if(now==M){
            for(int item:pick){
                sb.append(item+" ");
            }sb.append("\n");

            return;
        }
        for(int i=index;i<N;i++){
            pick[now]=arr[i];
            combination(now+1, index);
            if(pick[M-1]==arr[N-1]){
                index++;
            }

        }
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        arr=new int[N];
        pick=new int[M];
        for(int i=0;i<N;i++){
            arr[i]=scan.nextInt();
        }
        Arrays.sort(arr);
        combination(0, 0);//중복조합
        System.out.println(sb);
    }
}
