package baekjoon.level_gold;

import java.util.*;
import java.io.*;
public class BOJ2116_주사위쌓기 {
    static int N;
    static int[][]side;
    static int[][]dice;
    static int maxSum;
    static int[]couple={0,5,1,3,2,4};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        side=new int[N][4];
        dice=new int[N][6];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<6;j++){
                dice[i][j]=Integer.parseInt(st.nextToken());
            }

        }
        solution();
        System.out.println(maxSum);
    }

    static void solution(){
        for(int i=1;i<=6;i++){
            setDice(i);
            calculate();
        }
    }

    static void setDice(int firstTop){
        int topIndex=getIndex(firstTop, 0);
        int bottomIndex=getCoupleIndex(topIndex);
        int top=firstTop;
        int bottom=dice[0][bottomIndex];

        for(int i=0;i<N-1;i++){
            setSideDice(i, topIndex, bottomIndex);
            //다음 주사위 쌓을 준비
            bottom=top;
            bottomIndex=getIndex(bottom, i+1);
            topIndex=getCoupleIndex(bottomIndex);
            top=dice[i+1][topIndex];

        }
        setSideDice(N-1, topIndex, bottomIndex);
    }

    static void setSideDice(int diceIndex, int topIndex, int bottomIndex){
        int sideIndex=0;
        for(int i=0;i<6;i++){
            if(i==topIndex || i==bottomIndex) continue;
            side[diceIndex][sideIndex++]=dice[diceIndex][i];
        }
    }

    static int getIndex(int num, int diceIndex){
        for(int i=0;i<6;i++){
            if(dice[diceIndex][i]==num){
                return i;
            }
        }
        return -1;
    }

    static int getCoupleIndex(int index){
        int coupleIndex=0;
        for(int i=0;i<6;i++){
            if(index==couple[i]){
                coupleIndex=i;
                break;
            }
        }
        if(coupleIndex%2==0){
            return couple[coupleIndex+1];
        }else{
            return couple[coupleIndex-1];
        }
    }

    static void calculate(){
        int sum=0;
        for(int i=0;i<N;i++){
            int max=0;
            for(int j=0;j<4;j++){
                if(max<side[i][j]){
                    max=side[i][j];
                }
            }
            sum+=max;
        }
        if(sum>maxSum){
            maxSum=sum;
        }
    }
}
