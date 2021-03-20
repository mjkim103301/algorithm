package scofe2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2_2 {
    static int N;
    static int[] path, dp;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        path=new int[N];
        dp=new int[N];
        String input=br.readLine();
        for(int i=0;i<N;i++){
            path[i]=input.charAt(i)-'0';
        }
        solution();
        System.out.println(answer);
    }
    static void solution(){
       dfs(0,0);
    }
    static void dfs(int level, int start){
        if(level==N-1){
            answer++;
            return;
        }
        if(start>=N || path[start]==0){
            return;
        }
        for(int i=1;i<=2;i++){
            dfs(level+i, start+i);
        }
    }
}
