package baekjoon.level_gold;
import java.util.*;
import java.io.*;
public class BOJ17142_연구소3 {
    static int N,M;
    static int time, room, virusCnt;
    static int[]activeIndex;
    static int[][]map, copyMap;
    static int min=Integer.MAX_VALUE;
    static class Node{
        int y,x;
        int time;
        Node(int y, int x, int time){
            this.y=y;
            this.x=x;
            this.time=time;
        }
    }
    static ArrayList<Node> virus=new ArrayList<>();
    static Queue<Node> queue=new ArrayDeque<>();
    static int[][]dydx={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][N];
        copyMap=new int[N][N];
        activeIndex=new int[M];
        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<N;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
                if(map[y][x]==0){ // 빈칸
                    room++;
                }else if(map[y][x]==2){ // 바이러스
                    map[y][x]=-2;
                    virusCnt++;
                    virus.add(new Node(y, x, 0));
                }else{ // 벽
                    map[y][x]=-3;
                }
            }
        }
        solution();
        if(min==Integer.MAX_VALUE){
            min=-1;
        }
        System.out.println(min);
    }
    static void solution(){
        combi(0,0);
    }
    static void combi(int level, int start){
        if(level==M){
            //System.out.println(Arrays.toString(activeIndex));
            if(spread() && time<min){
                min=time;
            }
            return;
        }

        for(int i=start;i<virusCnt;i++){
            activeIndex[level]=i;
            combi(level+1, i+1);
        }
    }

    static boolean spread(){
        int remain=room;
        if(remain==0){
            time=0;
             return true;
        }
        Node now=null;
        queue.clear();
       for(int y=0;y<N;y++){
           copyMap[y]=Arrays.copyOf(map[y], N);
       }
       for(int i=0;i<M;i++){
           queue.offer(virus.get(activeIndex[i]));
       }
       while(!queue.isEmpty()){
            now=queue.poll();
            for(int i=0;i<4;i++){
                int y=now.y+dydx[i][0];
                int x=now.x+dydx[i][1];
                if(y<0||x<0||y>=N||x>=N)continue;
                if(copyMap[y][x]==-3 || copyMap[y][x]==-1 || copyMap[y][x]>0)continue; // 벽이거나 다른 활성 바이러스거나
                if(copyMap[y][x]==0){
                    remain--;
                    if(remain==0)break;
                }
                copyMap[y][x]=now.time+1;
                queue.offer(new Node(y, x, now.time+1));
            }
           if(remain==0)break;
       }
       if(remain==0){
           time=now.time+1;
           return true;
       }
       return false;
    }
}
