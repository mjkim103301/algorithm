package baekjoon.level_silver;

import java.util.*;
import java.io.*;
public class BOJ14888_연산자끼워넣기 {
    static int N;
    static int[]arr;
    static int[]operator;
    static int[]used;
    static int[]pick;
    static int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        operator=new int[4];
        used=new int[4];
        pick=new int[N-1];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            operator[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(max);
        System.out.println(min);
    }

    static void solution(){
        permutation(0);
    }
    static void permutation(int level){
        if(level==N-1){
            int ans=calculate();
            if(ans<min){
                min=ans;
            }
            if(ans>max){
                max=ans;
            }
            return;
        }

        for(int i=0;i<4;i++){
            if(used[i]<operator[i]){
                pick[level]=i;
                used[i]++;
                permutation(level+1);
                used[i]--;
            }
        }
    }

    static int calculate(){
        int ans=arr[0];
        for(int i=0;i<N-1;i++){
            if(pick[i]==0){
                ans+=arr[i+1];
            }else if(pick[i]==1){
                ans-=arr[i+1];
            }else if(pick[i]==2){
                ans*=arr[i+1];
            }else{
                ans/=arr[i+1];
            }
        }
        return ans;
    }
}
