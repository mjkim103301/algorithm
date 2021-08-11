package baekjoon;

import java.util.Scanner;

public class 연산자_끼워넣기 {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=scan.nextInt();
        }
        int[] oper=new int[4];//+, -, *, /
        for(int i=0;i<4;i++){
            oper[i]=scan.nextInt();
        }

        Solution_연산자 sol=new Solution_연산자();
        sol.solution(N, arr, oper);
    }
}
class Solution_연산자{
    int [] path;
    int Max=-1000000000;
    int Min=100000000;
    int Num;
    int []aarr;
    int[]ooper;
    int cal(int[] path){
        int num=aarr[0];
        int pathIndex=0;
        for(int i=1;i<Num;i++){
            if(path[pathIndex]==0){
                num+=aarr[i];
            }else if(path[pathIndex]==1){
                num-=aarr[i];
            }else if(path[pathIndex]==2){
                num*=aarr[i];
            }else if(path[pathIndex]==3){
                if(num<0){
                    num*=-1;
                    num/=aarr[i];
                    num*=-1;
                }else{
                    num/=aarr[i];
                }

            }
            pathIndex++;
        }
        return num;
    }
    void dfs(int level){
        if(level==Num-1){
            int temp=cal(path);
            if(temp>Max){
                Max=temp;
            }
            if(temp<Min){
                Min=temp;
            }
            return;
        }
        for(int i=0;i<4;i++){
            if(ooper[i]<=0) continue;
            ooper[i]--;
            path[level]=i;
            dfs(level+1);
            ooper[i]++;
            path[level]=-1;
        }


    }
    public void solution(int N, int[] arr, int[] oper){
        Num=N;
        aarr=arr.clone();
        ooper=oper.clone();
        path=new int[N-1];
        dfs(0);
        System.out.println(Max);
        System.out.println(Min);
    }

}
