package baekjoon;

import java.util.*;
import java.io.*;

class Node_14502{
    int y,x;
    public Node_14502(int y, int x){
        this.y=y;
        this.x=x;
    }
}
public class BOJ14502_연구소 {

    static int N,M;
    static int[][]visited;
    static int[][]map;
    static int[]dirY={1,-1,0,0};
    static int[]dirX={0,0,1,-1};
    static int max;
    static int [][]virusVisited;
    static int [][]virusMap;
    static Queue<Node_14502> queue=new ArrayDeque<>();
    static int zero;
    static int two;
    static void copy(int [][]from, int[][]to){
        for(int i=0;i<N;i++){
            to[i]=Arrays.copyOf(from[i],M);
        }
    }
    static void spread(){
        two=0;
        while(!queue.isEmpty()){
            Node_14502 Virus=queue.poll();
            for(int i=0;i<4;i++){
                int y=Virus.y+dirY[i];
                int x= Virus.x+dirX[i];
                if(y<0 ||x<0||y>=N||x>=M){
                    continue;
                }
                if(virusVisited[y][x]==1 || virusMap[y][x]==1)continue;
                two++;
                virusMap[y][x]=2;
                virusVisited[y][x]=1;
                queue.offer(new Node_14502(y, x));
            }
        }

    }
    static int findZero(){
        int count=0;
        for(int y=0;y<N;y++){
            for(int x=0;x<M;x++){
                if(virusMap[y][x]==0){
                   count++;
                }
            }
        }
        return count;
    }

    static void dfs(int level){
        if(level==3){
            copy(map, virusMap);
            for(int y=0;y<N;y++){
                for(int x=0;x<M;x++){
                    if(map[y][x]==2){
                        queue.offer(new Node_14502(y, x));
                        virusVisited=new int[N][M];
                        spread();
                    }
                }
            }
            int temp=zero-two;
            max=Math.max(max, temp);
            return;
        }
        for(int y=0;y<N;y++){
            for(int x=0;x<M;x++){
                if(visited[y][x]==0&&map[y][x]==0){
                    visited[y][x]=1;
                    map[y][x]=1;
                    dfs(level+1);
                    map[y][x]=0;
                    visited[y][x]=0;
                }
            }
        }
    }
    static int solution(){
        int answer=0;
        dfs(0);
        answer=max;
        return answer;
    }

   public static void main(String[]args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String []size=(br.readLine()).split(" ");
       N=parse(size[0]);
       M=parse(size[1]);
       map=new int[N][M];
       visited=new int[N][M];
       virusMap=new int[N][M];
       StringTokenizer st;
       for(int y=0;y<N;y++){
           st=new StringTokenizer(br.readLine());
           for(int x=0;x<M;x++){
               map[y][x]=parse(st.nextToken());
               if(map[y][x]==0){
                   zero++;
               }
           }
       }
       int ans=solution();
       System.out.println(ans);
   }
   static int parse(String s){
       return Integer.parseInt(s);
   }
}
