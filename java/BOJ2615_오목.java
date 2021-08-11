package ssafy.algo.study.week03;

import java.util.*;
import java.io.*;

public class BOJ2615_오목 {
    static char[][]map;
    static int[][] dydx={
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
    };
    static int winner, startY,startX;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        map=new char[19][19];
        for(int y=0;y<19;y++){
            map[y]=br.readLine().replace(" ", "").toCharArray();
        }

        solution();
        System.out.println(winner);
        if(winner!=0){
            System.out.println(startY+" "+startX);
        }
    }

    static void solution(){
        for(int y=0;y<19;y++){
            for(int x=0;x<19;x++){
                if(map[y][x]!='0'){
                    if(findWinner(y, x)){
                        return;
                    }
                }
            }
        }
    }

    static boolean findWinner(int y, int x){
        char target=map[y][x];
        for(int i=0;i<4;i++){
            int yy=y+dydx[i][0];
            int xx=x+dydx[i][1];
            if(!canGo(yy, xx) || map[yy][xx]!=target) continue;

            int prevY=y-dydx[i][0];
            int prevX=x-dydx[i][1];
            if(canGo(prevY, prevX) &&map[prevY][prevX]==target) continue;

            if(isFinish(yy, xx, i, target)){
                winner=target-'0';
                startY=y+1;
                startX=x+1;
                return true;
            }

        }
        return false;
    }

    static boolean canGo(int yy, int xx){
        if(yy<0 ||xx<0||yy>=19 ||xx>=19){
            return false;
        }
        return true;
    }

    static boolean isFinish(int y, int x, int direct, char target){
        for(int j=1;j<4;j++){
            y+=dydx[direct][0];
            x+=dydx[direct][1];

            if(!canGo(y, x)||map[y][x]!=target) return false;
        }

        y+=dydx[direct][0];
        x+=dydx[direct][1];
        if(canGo(y, x) && map[y][x]==target) return false;
        return true;
    }
}
