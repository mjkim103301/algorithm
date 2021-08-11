package baekjoon.level_silver;
import java.util.*;
import java.io.*;
public class BOJ10989_수정렬하기3 {
    static int N;
    static int cnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb=new StringBuilder();
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        cnt=new int[10001];

        N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            cnt[Integer.parseInt(br.readLine())]++;
        }

        for(int i=1;i<10001;i++){
            for(int j=0;j<cnt[i];j++){
                bw.write(i+"\n");
                //System.out.println(i);
            }
        }
        bw.flush();
        bw.close();
        br.close();
        //System.out.println(sb);
    }
}
