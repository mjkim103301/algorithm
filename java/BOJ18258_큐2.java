package baekjoon.level_silver;
import java.util.*;
import java.io.*;
public class BOJ18258_큐2 {
    static int N;
    static StringBuilder sb=new StringBuilder();
    static Queue<Integer> queue=new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        int lastPush=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String order=st.nextToken();

            switch(order){
                case "push":
                    lastPush=Integer.parseInt(st.nextToken());
                    queue.offer(lastPush);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(queue.poll()+"\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()+"\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1+"\n");
                    }else{
                        sb.append(0+"\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(queue.peek()+"\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        sb.append(-1+"\n");
                    }else{
                        sb.append(lastPush+"\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
