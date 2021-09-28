package baekjoon.level_bronze;

import java.util.*;
import java.io.*;

public class BOJ14696_딱지놀이 {
    static int N;
    static int[] cardA, cardB;
    static char winner;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            cardA=new int[5];
            cardB=new int[5];
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            for(int j=0;j<a;j++){
                cardA[Integer.parseInt(st.nextToken())]++;
            }
            st=new StringTokenizer(br.readLine());
            int b=Integer.parseInt(st.nextToken());
            for(int j=0;j<b;j++){
                cardB[Integer.parseInt(st.nextToken())]++;
            }
            solution();
            sb.append(winner+"\n");
        }
        System.out.println(sb);

    }
    static void solution(){
        for(int i=4;i>0;i--){
            if(cardA[i]==cardB[i]){
                continue;
            }else if(cardA[i]>cardB[i]){
                winner='A';
                return;
            }else{
                winner='B';
                return;
            }
        }
        winner='D';
    }
}
