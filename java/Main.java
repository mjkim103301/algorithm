package baekjoon;

import java.util.Scanner;

public class Main {

    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        Solution sol=new Solution();
        int [][]circle=new int[4][8];
        for(int y=0;y<4;y++){
            String line=scan.nextLine();
            for(int x=0;x<8;x++){
                circle[y][x]=line.charAt(x)-'0';
            }
        }
        int K=scan.nextInt();
        int [][]rotate=new int[K][2];
        for(int i=0;i<K;i++){
            for(int j=0;j<2;j++){
                rotate[i][j]=scan.nextInt();
            }
        }
        int ans=sol.solution(circle, K, rotate);
        System.out.println(ans);
    }
}
class Solution {
    int [][]ccircle;
    int[]rotated;
    void clockWise(int start){
        int temp=ccircle[start][7];
        int next=start+1;
        int prev=start-1;

        for(int i=7;i>0;i--){
            ccircle[start][i]=ccircle[start][i-1];
        }
        ccircle[start][0]=temp;
        rotated[start]=1;
        if(next<4 &&rotated[next]==0&& ccircle[next][6]!=ccircle[start][3]){
            counterClock(next);
        }else if(prev>=0 && rotated[prev]==0&&ccircle[prev][2]!=ccircle[start][7]){
            counterClock(prev);
        }
    }
    void counterClock(int start){
        int temp=ccircle[start][0];
        int next=start+1;
        int prev=start-1;
        for(int i=0;i<7;i++){
            ccircle[start][i]=ccircle[start][i+1];
        }
        ccircle[start][7]=temp;
        rotated[start]=1;
        if(next<4 && rotated[next]==0&&ccircle[next][6]!=ccircle[start][1]){
            clockWise(next);
        }else if(prev>=0 && rotated[prev]==0&&ccircle[prev][2]!=ccircle[start][5]){
            clockWise(prev);
        }

    }
    public int solution(int[][] circle, int K, int[][] rotate){
        ccircle=circle.clone();
        int score=0;
        for(int i=0;i<K;i++){
            rotated=new int[4];
            if(rotate[i][1]==1){
                clockWise(rotate[i][0]-1);
            }else{
                counterClock(rotate[i][0]-1);
            }
        }
        for(int i=0;i<4;i++){
            if(ccircle[i][0]==1){
                score+=(int)Math.pow(2, i);
            }
        }
        return score;
    }

}