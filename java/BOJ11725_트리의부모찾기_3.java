package baekjoon.level_silver;

import java.io.*;
import java.util.*;

//dfs
public class BOJ11725_트리의부모찾기_3 {
    static int N;
    static int []tree;
    static ArrayList<Integer>[] map;
    static boolean[]used;
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

    static void solution(){
        used[1]=true;
        int size=map[1].size();
        for(int x=0;x<size;x++){
            int child=map[1].get(x);
                tree[child]=1;
                used[child]=true;
                dfs(child);

        }
    }

    static void dfs(int parent){
        int size=map[parent].size();
        for(int x=0;x<size;x++){
            int child=map[parent].get(x);
            if( !used[child]){
                tree[child]=parent;
                used[child]=true;
                dfs(child);
            }
        }
    }

}
