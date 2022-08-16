package baekjoon.level_silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ11279_최대힙 {
    static int N;
    static Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.isEmpty()){
                    bw.write("0\n");
                }else{
                    bw.write(pq.poll()+"\n");
                }
            }else{
                pq.add(num);
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
