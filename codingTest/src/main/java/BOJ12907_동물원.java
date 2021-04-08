package 백준특강;

import java.io.*;
import java.util.*;

public class BOJ12907_동물원 {
    static int N;
    static int[] animal;
    static long answer;
    static int[]cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        animal=new int[N];
        cnt=new int[41];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            animal[i]=Integer.parseInt(st.nextToken());
            cnt[animal[i]]++;
        }

        solution();
        System.out.println(answer);
    }

    static void solution(){
        int prev=2;
        boolean one=false;
        int two=0;

        for(int i=0;i<=40;i++){
            if(cnt[i]>prev){
                answer=0;
                return;
            }
            prev=cnt[i];
            if(cnt[i]==1){
                one=true;
            }else if(cnt[i]==2){
                two++;
            }
        }
        answer=(int)Math.pow(2, two+(one?1:0));
    }
}
