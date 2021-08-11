package scofe2021_2차;

import java.io.*;
import java.util.*;

public class Main3_2 {
    static int N,Q;
    static Map<Integer, Integer> item=new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(st.nextToken());
        Q=Integer.parseInt(st.nextToken());

        for(int i=1;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            makeSet(num1,num2);
        }

        for(int i=0;i<Q;i++){
            st=new StringTokenizer(br.readLine());
            int parent=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            if(isTrue(parent, child)){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

   static void makeSet(int num1, int num2){
        item.put(num2, num1);
        if(!item.containsKey(num1)){
            item.put(num1, num1);
        }

   }
   static boolean isTrue(int parent, int child){
        int num=child;
        if(!item.containsKey(parent) || !item.containsKey(child))return false;
        while(item.get(num)!=num){
            if(item.get(num)==parent){
                return true;
            }
            num=item.get(num);
            if(!item.containsKey(num))return false;
        }
        return false;
   }
}
