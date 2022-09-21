package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ1920_수찾기_2 {
    static int N, M;
    static int[] map, target, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        N=Integer.parseInt(br.readLine());
        map=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            map[i]=Integer.parseInt(st.nextToken());
        }

        M=Integer.parseInt(br.readLine());
        target=new int[M];
        answer=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            target[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        for(int a:answer){
            sb.append(a+"\n");
        }
        System.out.println(sb);

    }

    static void solution(){
        Arrays.sort(map);
        long start=0;
        long end=map.length-1;

        for(int i=0;i<M;i++){
            boolean result=binarySearch(start, end, target[i]);
            if(result){
                answer[i]=1;
            }else{
                answer[i]=0;
            }
        }
    }

    static boolean binarySearch(long start, long end, int num){
        if(start>end){
            return false;
        }
        long mid=(start+end)/2;
        if(map[(int)mid]>num){
            return binarySearch(start, mid-1, num);
        }else if(map[(int)mid]<num){
            return binarySearch(mid+1, end, num);
        }else{
            return true;
        }
    }
}
