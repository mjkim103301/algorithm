package baekjoon.level_gold;

import java.io.*;
import java.util.*;

public class BOJ12100_2048Easy {
    static int N;
    static class Node{
        int num;
        int level;
        Node(){}
        Node(int num, int level){
            this.num=num;
            this.level=level;
        }
    }
    static Node[][]map, copyMap;
    static int[][]dydx={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    static ArrayList<Node> temp=new ArrayList<>();
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        map=new Node[N][N];
        copyMap=new Node[N][N];

        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<N;x++){
                map[y][x]=new Node(Integer.parseInt(st.nextToken()), 0);
            }
        }

        solution();
        System.out.println(max);
    }

    static void solution(){
        copy();
        permutation(0);
    }
    static int[]arr=new int[5];
    static void permutation(int level){
        if(level==5){
            for(int i=0;i<5;i++){
                moveBoard(arr[i], i+1);
            }
            getMax();
            copy();
            return;
        }

        for(int i=0;i<4;i++){
            arr[level]=i;
            permutation(level+1);
        }
    }

    static void moveBoard(int d, int level){
        int size=0;
        if(d==0){//상
            for(int x=0;x<N;x++){
                temp.clear();
                for(int y=0;y<N;y++){
                    Node now=copyMap[y][x];
                    if(now.num>0){
                        size=temp.size();
                        if(size>0 && temp.get(size-1).num==now.num && temp.get(size-1).level<level){
                            temp.get(size-1).num=now.num*2;
                            temp.get(size-1).level=level;
                        }else{
                            temp.add(now);
                        }
                        copyMap[y][x]=new Node();
                    }
                }
                size=temp.size();
                for(int y=0;y<N;y++){
                    if(size==y) break;
                    copyMap[y][x]=temp.get(y);
                }

            }

        }else if(d==1){//하
            for(int x=0;x<N;x++){
                temp.clear();
                for(int y=N-1;y>=0;y--){
                    Node now=copyMap[y][x];
                    if(now.num>0){
                        size=temp.size();
                        if(size>0 && temp.get(size-1).num==now.num && temp.get(size-1).level<level){
                            temp.get(size-1).num=now.num*2;
                            temp.get(size-1).level=level;
                        }else{
                            temp.add(now);
                        }
                        copyMap[y][x]=new Node();
                    }
                }
                size=temp.size();
                for(int y=N-1;y>=0;y--){
                    if(size==N-1-y) break;
                    copyMap[y][x]=temp.get(N-1-y);
                }

            }

        }else if(d==2){//좌
            for(int y=0;y<N;y++){
                temp.clear();
                for(int x=0;x<N;x++){
                    Node now=copyMap[y][x];
                    if(now.num>0){
                        size=temp.size();
                        if(size>0 && temp.get(size-1).num==now.num && temp.get(size-1).level<level){
                            temp.get(size-1).num=now.num*2;
                            temp.get(size-1).level=level;
                        }else{
                            temp.add(now);
                        }
                        copyMap[y][x]=new Node();
                    }
                }
                size=temp.size();
                for(int x=0;x<N;x++){
                    if(size==x) break;
                    copyMap[y][x]=temp.get(x);
                }

            }

        }else if(d==3){//우
            for(int y=0;y<N;y++){
                temp.clear();
                for(int x=N-1;x>=0;x--){
                    Node now=copyMap[y][x];
                    if(now.num>0){
                        size=temp.size();
                        if(size>0 && temp.get(size-1).num==now.num && temp.get(size-1).level<level){
                            temp.get(size-1).num=now.num*2;
                            temp.get(size-1).level=level;
                        }else{
                            temp.add(now);
                        }
                        copyMap[y][x]=new Node();
                    }
                }
                size=temp.size();
                for(int x=N-1;x>=0;x--){
                    if(size==N-1-x) break;
                    copyMap[y][x]=temp.get(N-1-x);
                }

            }
        }
    }

    static void getMax(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(copyMap[y][x].num>max){
                    max=copyMap[y][x].num;
                }
            }
        }
    }

    static void copy(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                copyMap[y][x]=new Node(map[y][x].num, map[y][x].level);
            }

        }
    }
}
