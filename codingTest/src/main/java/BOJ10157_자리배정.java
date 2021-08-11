package baekjoon.level_silver;

import java.util.*;

public class BOJ10157_자리배정 {
    static int C,R,K;
    static int[][] map;
    static int answerX,answerY;
    static int y,x;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
       C=scan.nextInt();
       R=scan.nextInt();
       K=scan.nextInt();


       map=new int[R][C];
       answerY=R;
       if(solution()){
           answerX=x+1;
           answerY=answerY-y;
           System.out.println(answerX+" "+answerY);
       }else{
           System.out.println(0);
       }

    }

    static boolean solution(){
        if(C*R<K){
            return false;
        }
        int small=C;
        if(small>R){
            small=R;
        }
        y=R-1;
        x=0;
        int num=1;
        for(int i=0;i<small;i++){//달팽이 회전 수
            //위
            for(int j=0;j<R;j++){
                map[y][x]=num;
                if(num==K){
                    return true;
                }
                num++;
                y--;
            }
            y++;
            x++;
            R--;
            C--;
            //오른쪽
            for(int j=0;j<C;j++){
                map[y][x]=num;
                if(num==K){
                    return true;
                }
                num++;
                x++;
            }
            x--;
            y++;


            //아래
            for(int j=0;j<R;j++){
                map[y][x]=num;
                if(num==K){
                    return true;
                }
                num++;
                y++;
            }
            y--;
            x--;
            R--;
            C--;
            //왼쪽
            for(int j=0;j<C;j++){
                map[y][x]=num;
                if(num==K){
                    return true;
                }
                num++;
                x--;
            }
            x++;
            y--;

        }
        return true;
    }
}
