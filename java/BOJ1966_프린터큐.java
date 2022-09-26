package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966_프린터큐 {
    static int T, N, M;
    static class Node{
        int index;
        int priority;
        public Node(int index, int priority){
            this.index=index;
            this.priority=priority;
        }
    }
    static Queue<Node> queue=new LinkedList<>();
    static Queue<Integer> priorities=new PriorityQueue<>(Comparator.reverseOrder());
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int priority=Integer.parseInt(st.nextToken());
                priorities.add(priority);
                queue.add(new Node(j,priority ));
            }
            solution();
            System.out.println(answer);
            queue.clear();
            priorities.clear();
        }
    }
    static void solution(){
        int count=0;
        int priority=priorities.poll();
        while(!queue.isEmpty()){
            Node now=queue.poll();
            if(now.priority==priority){
                count++;
                if(now.index==M){
                    answer=count;
                    return;
                }
                priority=priorities.poll();
            }else{
                queue.add(now);
            }
        }
    }
}
