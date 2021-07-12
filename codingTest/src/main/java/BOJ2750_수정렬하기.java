package baekjoon.level_bronze;
import java.util.*;
import java.io.*;

public class BOJ2750_수정렬하기 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            System.out.println(arr[i]);
        }
    }
}
