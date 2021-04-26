package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ21608_상어초등학교 {
    static int N;
    static int[][]map;
    static class Node implements Comparable<Node>{
        int y,x;
        int like;
        int empty;
        Node(int y, int x){
            this.y=y;
            this.x=x;
        }

        @Override
        public int compareTo(Node o) {
            int diff=o.like-this.like;
            if(diff==0){
                int diff2=o.empty-this.empty;
                if(diff2==0){
                    int diff3=this.y-o.y;
                    if(diff3==0){
                        return this.x-o.x;
                    }
                    return diff3;
                }
                return diff2;
            }
            return diff;
        }
    }
    static ArrayList<Node> seat=new ArrayList<>();
    static Set<Integer>[] set;
    static int[][]dydx={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
    };
    static int []point={0,1,10,100,1000};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        set=new HashSet[N*N+1];
        for(int i=0;i<=N*N;i++){
            set[i]=new HashSet<>();
        }
        for(int i=0;i<N*N;i++){
            st=new StringTokenizer(br.readLine());
            int id=Integer.parseInt(st.nextToken());
            seat.clear();
            for(int j=0;j<4;j++){
                set[id].add(Integer.parseInt(st.nextToken()));
            }
            solution(id);
        }
        System.out.println( getScore());
    }

    static void solution(int id){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(map[y][x]>0)continue;
                Node now=new Node(y,x);
                for(int i=0;i<4;i++){
                    int r=y+dydx[i][0];
                    int c=x+dydx[i][1];

                    if(r<0||c<0||r>=N||c>=N)continue;
                    if(set[id].contains(map[r][c])){
                        now.like++;
                    }else if(map[r][c]==0){
                        now.empty++;
                    }
                }
                seat.add(now);
            }
        }

        Collections.sort(seat);
        Node here=seat.get(0);
        map[here.y][here.x]=id;
    }

    static int getScore(){
        int score=0;
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                int id=map[y][x];
                int cnt=0;
                for(int i=0;i<4;i++){
                    int r=y+dydx[i][0];
                    int c=x+dydx[i][1];
                    if(r<0||c<0||r>=N||c>=N)continue;
                    if(set[id].contains(map[r][c])){
                        cnt++;
                    }
                }
                score+=point[cnt];
            }
        }
        return score;
    }

}
