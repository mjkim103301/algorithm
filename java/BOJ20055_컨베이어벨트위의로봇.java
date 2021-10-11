package baekjoon.level_silver;

import java.util.*;
import java.io.*;
public class BOJ20055_컨베이어벨트위의로봇 {
    static int N,K;
    static int[]belt;
    static int level, zeroCnt;
    static boolean []robotLocate;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        belt=new int[2*N];
        robotLocate=new boolean[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;i++){
            belt[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(level);
    }

    static void solution(){
        while(zeroCnt<K){
            level++;
          //  System.out.println("level: "+level+" "+Arrays.toString(belt));
            rotate();
            move();
            robot();
        }
      //  System.out.println("level: "+level+" "+Arrays.toString(belt));
    }

    static void rotate(){
        int temp=belt[2*N-1];
        for(int i=2*N-1;i>0;i--){
            belt[i]=belt[i-1];
        }
        belt[0]=temp;

        for(int i=N-1;i>0;i--){
            robotLocate[i]=robotLocate[i-1];
        }
        robotLocate[0]=false;
    }

    static void move(){
        if(robotLocate[N-1]){
            robotLocate[N-1]=false;
        }
        for(int i=N-2;i>=0;i--){
            if(robotLocate[i] && !robotLocate[i+1] && belt[i+1]>0){
                robotLocate[i]=false;
                robotLocate[i+1]=true;
                belt[i+1]--;
                if(belt[i+1]==0){
                    zeroCnt++;
                }
            }
        }
    }

    static void robot(){
        if(belt[0]>0){
            robotLocate[0]=true;
            belt[0]--;
            if(belt[0]==0){
                zeroCnt++;
            }
        }
    }

}
