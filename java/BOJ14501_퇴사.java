package baekjoon.level_silver;

import java.util.*;
import java.io.*;
public class BOJ14501_퇴사 {
    static int N;
    static int[][]arr;
    static int []pay;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        arr=new int[N][2];
        pay=new int[N+1];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(pay[0]);
    }

    static void solution(){
        for(int i=N-1;i>=0;i--){
            int end=i+arr[i][0];
            if(end>N) {
                pay[i]=pay[i+1];
            }else if(pay[end]+arr[i][1]>pay[i+1]){
                pay[i]=pay[end]+arr[i][1];
            }else{
                pay[i]=pay[i+1];
            }
        }
    }
}
