package baekjoon.level_silver;
import java.util.*;
import java.io.*;

public class BOJ2751_수정렬하기2 {

    static int N;
    static Integer[]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());
        arr=new Integer[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(br.readLine());

        }

        Collections.sort(Arrays.asList(arr));


        for(int i=0;i<N;i++){
            bw.write(arr[i]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
