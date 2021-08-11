package scofe2021_2차;

import java.io.*;
import java.util.*;

public class Main2 {
    static int N;
    static class Node implements Comparable<Node>{
        int id,cost;
        public Node(int id, int cost){
            this.id=id;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }
    static LinkedList<Node>[] map;
    static int []path;
    static Map<String,Integer> contry=new HashMap<>();
    static int[][]link;
    static int answer;
    static boolean []visited;
    static int contryNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        link=new int[N][3];
        int index=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            String c1=st.nextToken();
            String c2=st.nextToken();
            link[i][2]=Integer.parseInt(st.nextToken());

            if(contry.containsKey(c1)){
                link[i][0]=contry.get(c1);
            }else{
                contry.put(c1, index);
                link[i][0]=index++;
            }
            if(contry.containsKey(c2)){
                link[i][1]=contry.get(c2);
            }else{
                contry.put(c2, index);
                link[i][1]=index++;
            }
        }
        solution();
        System.out.println(answer);
    }
    static void solution(){
        contryNum=contry.size();
        map=new LinkedList[contryNum];

        for(int i=0;i<contryNum;i++){
            map[i]=new LinkedList<>();
        }

        for(int i=0;i<N;i++){
            map[link[i][0]].addFirst(new Node(link[i][1], link[i][2]));
            map[link[i][1]].addFirst(new Node(link[i][0], link[i][2]));
        }
        prim();
    }

    static void prim() {
        path=new int[contryNum];
        visited=new boolean[contryNum];
        int connect=0;
        PriorityQueue<Node> queue=new PriorityQueue<>();
        Arrays.fill(path, Integer.MAX_VALUE);
        path[0]=0;
        queue.offer(new Node(0,0));
        while(!queue.isEmpty()){
            Node now=queue.poll();
            if(visited[now.id])continue;

            answer+=now.cost;
            visited[now.id]=true;
            if(++connect==contryNum)break;

          Iterator<Node> iter=  map[now.id].iterator();
            while(iter.hasNext()){
                Node child= (Node) iter.next();
                if(visited[child.id])continue;
                if(path[child.id]>child.cost){
                    path[child.id]=child.cost;
                    queue.offer(new Node(child.id, child.cost));
                }
            }

        }
    }
}
