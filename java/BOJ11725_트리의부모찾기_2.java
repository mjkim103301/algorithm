package baekjoon.level_silver;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

//bfs
public class BOJ11725_트리의부모찾기_2 {
    static int N;
    static int []tree;
    static ArrayList<Integer>[]map;
    static boolean[]used;
    static Queue<Integer> queue=new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());
        tree=new int[N+1];
        tree[1]=-1;
        map=new ArrayList[N+1];
        used=new boolean[N+1];
        for(int i=0;i<N+1;i++){
            map[i]=new ArrayList<>();
        }
        for(int i=2;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            int temp1=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());
            map[temp1].add(temp2);
            map[temp2].add(temp1);
        }
        solution();
        for(int i=2;i<=N;i++){
            bw.append(tree[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    static void setTree(int temp1, int temp2){
        int parent=0,child=0;
        if(tree[temp1]!=0){
            parent=temp1;
            child=temp2;
        }else{
            parent=temp2;
            child=temp1;
        }
        tree[child]=parent;
        used[parent]=true;
        used[child]=true;
    }
    static void solution(){
        queue.offer(1);
        used[1]=true;
        while(!queue.isEmpty()){
            int now=queue.poll();
            int size=map[now].size();
           for(int x=0;x<size;x++){
               int child=map[now].get(x);
               if(!used[child] || !used[now]){
                   setTree(now, child);
                   queue.offer(child);
               }
           }
        }
    }
}
