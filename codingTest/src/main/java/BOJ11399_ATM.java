package 백준특강;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11399_ATM {
    static int N;
    static int []arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(answer);
    }
    static void solution(){
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                answer+=arr[j];
            }
        }
    }
}
