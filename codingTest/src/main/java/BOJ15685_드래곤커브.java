package baekjoon.level_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15685_드래곤커브 {
    static int N;
    static int[] curve=new int[1024];
    static int[][]dydx={
            {0,1},
            {-1,0},
            {0,-1},
            {1,0},
    };
    static int answer;
    static boolean[][]map=new boolean[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        init();
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            int g=Integer.parseInt(st.nextToken());
            solution(x, y, d, g);
        }
        findDragonCurve();
        System.out.println(answer);
    }
    static void init(){
        curve[0]=0;
        for(int i=1;i<1024;i++){
            for(int j=i-1;j>=0;j--){
                curve[i++]=(curve[j]+1)%4;
            }
            i--;
        }
    }
    static void solution(int x, int y, int d, int g){
        int end=(int)Math.pow(2,g);
        int yy=y,xx=x;
        map[yy][xx]=true;
        for(int i=0;i<end;i++){
            yy=yy+dydx[(curve[i]+d)%4][0];
            xx=xx+dydx[(curve[i]+d)%4][1];
            map[yy][xx]=true;
        }
    }
    static void findDragonCurve(){
        for(int y=0;y<100;y++){
            for(int x=0;x<100;x++){
                if(map[y][x] && isAllDragonCurve(y,x)){
                    answer++;
                }
            }
        }
    }

    static boolean isAllDragonCurve(int y, int x){
        for(int i=y;i<=y+1;i++){
            for(int j=x;j<=x+1;j++){
                if(!map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
