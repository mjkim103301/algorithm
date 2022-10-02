package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ10845_큐 {
    static Deque<Integer> deque=new LinkedList<>();
    static StringBuilder sb=new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String order=st.nextToken();
            switch(order){
                case "push":{
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "pop":{
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(deque.poll()+"\n");
                    }
                    break;
                }
                case "size":{
                    sb.append(deque.size()+"\n");
                    break;
                }
                case "empty":{
                    if(deque.isEmpty()){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                }
                case "front":{
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(deque.peekFirst()+"\n");
                    }
                    break;
                }
                case "back":{
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    }else{
                        sb.append(deque.peekLast()+"\n");
                    }
                    break;
                }
                default:
                    break;
            }

        }

        System.out.println(sb);
    }
}
