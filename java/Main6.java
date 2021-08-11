package scofe2021;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
class Main6 {
    static int W,H;
    static int[][]map;
    static boolean[][]visited;

    static int [][]dydx={
            {0,1},
            {1,0}
    };
    static BigInteger answer=new BigInteger("0");
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        W=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        map=new int[H][W];
        visited=new boolean[H][W];

        for(int y=0;y<H;y++){
            st= new StringTokenizer(br.readLine());
            for(int x=0;x<W;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(answer);
    }
    static void solution(){
        dfs(0,0,0,new BigInteger(String.valueOf(map[0][0])));
    }
    static void dfs(int level, int y, int x, BigInteger cloth){
        if(y==H-1 && x==W-1){
            if(cloth.compareTo(answer)==1){
                answer=cloth;
            }
            return;
        }
        visited[y][x]=true;

        for(int i=0;i<2;i++){
            int yy=y+dydx[i][0];
            int xx=x+dydx[i][1];
            if(yy<0 ||xx<0 || yy>=H ||xx>=W){
                continue;
            }
            if(visited[yy][xx])continue;
            dfs(level+1, yy, xx, cloth.add(BigInteger.valueOf(map[yy][xx])));
        }
    }
}
