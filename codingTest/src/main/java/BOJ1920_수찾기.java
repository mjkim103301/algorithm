package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ1920_수찾기 {
    static int N;
    static int[] nArr;
    static int M;
    static int [] mArr;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        nArr=new int[N];
        for(int i=0;i<N;i++){
            nArr[i]=Integer.parseInt(st.nextToken());
        }

        M=Integer.parseInt(br.readLine());
        mArr=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            mArr[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(sb);
    }
    static void solution(){
        Arrays.sort(nArr);
        for(int i=0;i<M;i++){
            int index=Arrays.binarySearch(nArr, mArr[i]);
            if(index<0){
                sb.append("0\n");
            }else{
                sb.append("1\n");
            }
        }
    }

}
