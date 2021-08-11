package com.java.algo;

import java.io.*;
import java.util.*;

/**
 * 백준 4963번 섬의 개수
 * 링크: https://www.acmicpc.net/problem/4963
 * 관련 알고리즘
 * 	그래프, 너비우선 탐색, 깊이우선 탐색
 * 
 * 21.01.28
 * */

class Node{
    int y,x;
    public Node(int y, int x){
        this.y=y;
        this.x=x;
    }
}

public class BOJ4963_섬의개수 {
    static int w,h;
    static int[][]map;
    static int[][]visited;
    static Queue<Node> queue=new LinkedList<>();
    static int[][]dir={
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
            {1,1},
            {1,-1},
            {-1,1},
            {-1,-1},
    };

    static boolean init(int startY, int startX){
        for(int y=startY;y<h;y++){
            for(int x=startX;x<w;x++){
                if(visited[y][x]==0 && map[y][x]==1){
                    queue.offer(new Node(y, x));
                    visited[y][x]=1;
                    return true;
                }
            }
            startX=0;
        }
        return false;
    }

    static int findLand(){
        int land=0;
        int startY=0, startX=0;
        while(init(startY,startX)){
            land++;
            startY=queue.peek().y;
            startX=queue.peek().x;
            while(!queue.isEmpty()){
                Node now=queue.poll();
                for(int i=0;i<8;i++){
                    int y=now.y+dir[i][0];
                    int x=now.x+dir[i][1];
                    if(y<0 ||x<0 || y>=h ||x>=w) continue;
                    if(visited[y][x]==1)continue;
                    visited[y][x]=1;
                    if(map[y][x]==1){
                        queue.offer(new Node(y, x));
                    }
                }
            }
        }
        return land;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s;
        while(true){
           s=br.readLine();
           String[]input=s.split(" ");
            w=parse(input[0]);
            h=parse(input[1]);
            if(w==0 && h==0) break;
            map=new int[h][w];
            visited=new int[h][w];
            for(int y=0;y<h;y++){
                st=new StringTokenizer(br.readLine());
                for(int x=0;x<w;x++){
                    map[y][x]=parse(st.nextToken());
                }
            }
            int land=findLand();
            System.out.println(land);
        }
    }
    static int parse(String s){
        return Integer.parseInt(s);
    }
}
