package baekjoon.silver;

import java.io.*;
import java.util.*;
public class BOJ1927_최소힙 {
    static int N;
    static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int order=Integer.parseInt(br.readLine());
            if(order==0){
                if(minHeap.isEmpty()){
                    sb.append("0\n");
                }else{
                    sb.append(minHeap.poll()+"\n");
                }
            }else{
                minHeap.add(order);
            }
        }

        System.out.println(sb);
    }
}
