package scofe2021_2차;

import java.io.*;
import java.util.*;

public class Main3 {
    static int N,Q;
    static int[]map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());
        map=new int[N+1];
        init();
        for(int i=1;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            makeSet(num1,num2);
        }

        for(int i=0;i<Q;i++){
            st=new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            if(isTrue(parent, child)){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
    static void init(){
        for(int i=1;i<=N;i++){
            map[i]=i;
        }
    }
   static void makeSet(int num1, int num2){
        map[num2]=num1;
   }
   static boolean isTrue(int parent, int child){
        int num=child;
        if(parent>N || child>N)return false;
        while(map[num]!=num){
            if(map[num]==parent){
                return true;
            }
            num=map[num];
        }
        return false;
   }
}
