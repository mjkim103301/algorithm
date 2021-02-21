package baekjoon.level_bronze;

import java.util.*;
import java.io.*;
public class BOJ20999_일우는야바위꾼 {
    static int N,X,K;
    static void change(int num1, int num2){
        if(num1==X){
            X=num2;
        }else if(num2==X){
            X=num1;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        N=parse(st.nextToken());
        X=parse(st.nextToken());
        K=parse(st.nextToken());

        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            int num1=parse(st.nextToken());
            int num2=parse(st.nextToken());
            change(num1, num2);
        }
        System.out.println(X);
    }

    static int parse(String s){
        return Integer.parseInt(s);
    }
}
