package baekjoon.level_bronze;

import java.util.*;
import java.io.*;

public class BOJ10163_색종이 {
    static class Node{
        int x, y;
        int width,height;
        public Node(int x, int y, int width, int height){
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
        }
    }
    static Node[] papers;
    static int[][]map;
    static int[]store;
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=parse(br.readLine());
        papers=new Node[N+1];
        map=new int[101][101];
        store=new int[N+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            papers[i]=new Node(parse(st.nextToken()), parse(st.nextToken()), parse(st.nextToken()), parse(st.nextToken()));
        }
        solution();
        print();
    }
    static int parse(String s){
        return Integer.parseInt(s);
    }
    static void print(){
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(store[i]+"\n");
        }
        System.out.print(sb);
    }
    static void solution(){
        for(int i=1;i<=N;i++){
            getArea(i);
        }
    }

    static void getArea(int paperNum){
        Node paper=papers[paperNum];
        for(int y=paper.y;y<paper.y+paper.height;y++){
            for(int x=paper.x;x<paper.x+paper.width;x++){
                int num=map[y][x];
                if(num!=0){
                    store[num]--;
                }
                store[paperNum]++;
                map[y][x]=paperNum;
            }
        }
    }
}
