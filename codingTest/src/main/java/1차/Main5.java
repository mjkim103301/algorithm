package scofe2021;
import java.io.*;
import java.util.*;

class Main5 {
    static int W,H;
    static char[][]map;
    static boolean[][]visited;
    static class Node{
        int y,x;
        int change;
        public Node(int y, int x, int change){
            this.y=y;
            this.x=x;
            this.change=change;
        }
    }
    static Queue<Node> start=new ArrayDeque<>();
    static Queue<Node> queue=new ArrayDeque<>();
    static int answer=20001;

    static int[][]dydx={
            {1,0},
            {0,1},
            {0,-1},
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        W=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        map=new char[H][W];
        visited=new boolean[H][W];
        String input;
        for(int y=0;y<H;y++){
            input=br.readLine();
            for(int x=0;x<W;x++){
                map[y][x]=input.charAt(x);
                if(map[y][x]=='c'){
                    start.offer(new Node(y, x, 0));
                }
            }
        }
        solution();
        if(answer==20001){
            System.out.println("-1");
        }else{
            System.out.println(answer);
        }
    }
    static void solution(){
        while(!start.isEmpty()){
            Node now=start.poll();
            queue.clear();
            queue.offer(now);
            visited=new boolean[H][W];
            visited[now.y][now.x]=true;
            bfs();
        }
    }

    static void bfs(){
        int change=0;
        boolean isOut=false;
        while(!queue.isEmpty()){

            Node now=queue.poll();
            for(int i=0;i<3;i++){
                int y=now.y+dydx[i][0];
                int x=now.x+dydx[i][1];

                if(y<0 ||x<0 || y>=H ||x>=W)continue;
                if(visited[y][x] || map[y][x]!='.')continue;
                visited[y][x]=true;
                int c=now.change;
                if(x!=now.x){
                    c++;
                }
                if(y==H-1){
                    change=c;
                    isOut=true;
                    break;
                }
                queue.offer(new Node(y, x, c));
            }
            if(isOut){
                break;
            }

        }
        if(isOut){
            if(change<answer){
                answer=change;
            }
        }
    }
}
