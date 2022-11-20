package baekjoon.silver;
import java.util.*;
import java.io.*;
public class BOJ11659_구간합구하기4 {
    static int N,M;
    static int[]map;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            map[i]=map[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            solution(start, end);
        }
        System.out.println(sb);

    }

    static void solution(int start, int end){
        int answer=map[end]-map[start-1];
        sb.append(answer+"\n");
    }
}
