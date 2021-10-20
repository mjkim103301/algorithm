package baekjoon.level_silver;

import java.util.*;
import java.io.*;
public class BOJ2667_단지번호붙이기 {
    static int N;
    static boolean[][]map;
    static ArrayList<Integer> list=new ArrayList<>();
    static StringBuilder sb=new StringBuilder();
    static Queue<int[]> queue=new LinkedList<>();
    static int[][]dydx={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        map=new boolean[N][N];
        for(int y=0;y<N;y++){
            String input=br.readLine();
            for(int x=0;x<N;x++){
                if(input.charAt(x)=='1'){
                    map[y][x]=true;
                }
            }
        }

        solution();
        System.out.print(sb);
    }

    static void solution(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(map[y][x]){
                    bfs(y,x);
                }
            }
        }
        int size=list.size();
        sb.append(size+"\n");
        Collections.sort(list);
        for(int i=0;i<size;i++){
            sb.append(list.get(i)+"\n");
        }
    }

    static void bfs(int y, int x){
        queue.clear();
        queue.offer(new int[]{y,x});
        int num=1;
        map[y][x]=false;
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            for(int i=0;i<4;i++){
                int ny=now[0]+dydx[i][0];
                int nx=now[1]+dydx[i][1];
                if(ny<0||nx<0||ny>=N||nx>=N)continue;
                if(!map[ny][nx])continue;
                num++;
                map[ny][nx]=false;
                queue.offer(new int[]{ny,nx});
            }

        }

        list.add(num);
    }
}
