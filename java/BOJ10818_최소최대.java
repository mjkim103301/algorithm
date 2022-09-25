package baekjoon.level_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10818_최소최대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int n=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }

        System.out.println(min+" "+max);
    }
}
