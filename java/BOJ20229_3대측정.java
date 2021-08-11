package baekjoon.level_bronze;
import java.util.*;
import java.io.*;

public class BOJ20229_3대측정 {
    static int K,L;

    static boolean isValid(int student1, int student2, int student3){
        if(student1<L||student2<L||student3<L){
            return false;
        }
        int sum=student1+student2+student3;
        if(sum<K){
            return false;
        }
        return true;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=parse(st.nextToken());
        K=parse(st.nextToken());
        L=parse(st.nextToken());
        int cnt=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int student1=parse(st.nextToken());
            int student2=parse(st.nextToken());
            int student3=parse(st.nextToken());

            if(isValid(student1, student2, student3)){
                cnt++;
                sb.append(student1+" ").append(student2+" ").append(student3+" ");
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
    static int parse(String s){
        return Integer.parseInt(s);
    }
}
