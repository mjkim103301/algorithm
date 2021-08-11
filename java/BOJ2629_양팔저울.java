package ssafy.algo.study.week06;

import java.util.*;
import java.io.*;

public class BOJ2629_양팔저울 {
    static int weightNum;
    static int beadNum;
    static int []weightArr;

    static boolean[][]dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        weightNum=Integer.parseInt(br.readLine());
        int maxBead=500*weightNum;
        weightArr=new int[weightNum];
        dp=new boolean[weightNum+1][maxBead+1];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<weightNum;i++){
            weightArr[i]=Integer.parseInt(st.nextToken());
        }
        solution();

        beadNum=Integer.parseInt(br.readLine());

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<beadNum;i++){
            int bead=Integer.parseInt(st.nextToken());

            if(bead>maxBead){
                sb.append("N ");
            }else if(dp[weightNum][bead]){
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }
        System.out.print(sb);
    }

    static void solution(){
        subset(0,0,0);
    }

    static void subset(int level, int left, int right){

        int weight=Math.abs(right-left);
        if(dp[level][weight])return;
        dp[level][weight]=true;
        if(level==weightNum)return;

        subset(level+1, left, right+weightArr[level]);
        subset(level+1, left+weightArr[level], right);
        subset(level+1, left, right);
    }
}
