package baekjoon.level_bronze;

import java.util.*;
import java.io.*;
public class BOJ13458_시험감독 {
    static int N;
    static int[] students;
    static int B,C;
    static long answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        students=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            students[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        B=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        solution();
        System.out.println(answer);

    }

    static void solution(){
        for(int i=0;i<N;i++){
            int now=students[i]-B;
            answer++;

            if(now<0) continue;
            answer+=now/C;
            if(now%(double)C!=0.0){
                answer++;
            }

        }
    }
}
