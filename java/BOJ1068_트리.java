package baekjoon.level_gold;

import java.util.*;
import java.io.*;
public class BOJ1068_트리 {
   static int N;
   static int[]arr;
   static boolean[]check;
   static int delete, deleteCnt;
   static ArrayList<Integer> temp=new ArrayList<>();
   static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        check=new boolean[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        delete=Integer.parseInt(br.readLine());
        solution();
        System.out.println(answer);
    }

    static void solution(){
        temp.add(delete);
        arr[delete]=-2;
        do{
          deleteNode();
        }while(deleteCnt>0);
        countLeefNode();
    }

    static void deleteNode(){
        deleteCnt=0;
        for(int i=0;i<N;i++){
            if(temp.contains(arr[i])){
               arr[i]=-2;
               temp.add(i);
               deleteCnt++;
            }
        }
    }

    static void countLeefNode(){
        int node=N;
        for(int i=0;i<N;i++){
            if(arr[i]>-1 && !check[arr[i]]){
                check[arr[i]]=true;
                node--;
            }else if(arr[i]<-1){
                node--;
            }
        }
        answer=node;
    }
}
