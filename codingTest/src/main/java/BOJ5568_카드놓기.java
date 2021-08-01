package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ5568_카드놓기 {
    static int N,K;
    static int[]arr, pick;
    static boolean[]selected;
    static Set<Integer> canMake=new HashSet<>();
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        K=Integer.parseInt(br.readLine());

        arr=new int[N];
        pick=new int[K];
        selected=new boolean[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        solution();
        System.out.println(answer);
    }
    static void solution(){
        permutation(0);
        answer=canMake.size();
    }
    static void permutation( int num){
        if(num==K){
            String card="";
            for(int i=0;i<K;i++){
                card+=pick[i];
            }
            canMake.add(Integer.parseInt(card));
            return;
        }
        for(int j=0;j<N;j++){
            if(selected[j])continue;
            pick[num]=arr[j];
            selected[j]=true;
            permutation(num+1);
            selected[j]=false;
        }

    }

}



