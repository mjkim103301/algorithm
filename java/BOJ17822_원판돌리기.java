package baekjoon.level_gold;

import java.util.*;
import java.io.*;
public class BOJ17822_원판돌리기 {
    static int N,M,T;
    static int[][]circle;
    static int [][]rotate;
    static int[][] dydx={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
    };
    static int sum, numCnt;
    static ArrayList<int[]> deleteNum=new ArrayList<>();
    static boolean[][]visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        circle=new int[N+1][M];
        rotate=new int[T][3];
        visit=new boolean[N+1][M];

        for(int y=1;y<=N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<M;x++){
                circle[y][x]=Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0;y<T;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<3;x++){
                rotate[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(sum);
    }

    static void solution(){
        for(int y=0;y<T;y++){
            //print(y);
            rotateCircle(y);
           // print(y+1);
            if(!delete()){
               // print(y+1);
                changeNum();
            }
        }
      //  print(T);
        getSum();
    }

    static void print(int rotateN){
        System.out.println("================"+rotateN+"==============");
        for(int y=1;y<=N;y++){
            for(int x=0;x<M;x++){
                System.out.print(circle[y][x]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void rotateCircle(int index){
        int circleN=rotate[index][0];
        int direct=rotate[index][1];
        int rotateN=rotate[index][2];

        for(int i=1;i<=N;i++){
            if(i%circleN!=0)continue;
            if(direct==0){//시계
                for(int k=0;k<rotateN;k++){
                    int temp=circle[i][M-1];
                    for(int j=M-1;j>0;j--){
                        circle[i][j]=circle[i][j-1];
                    }
                    circle[i][0]=temp;
                }

            }else if(direct==1){//반시계
                for(int k=0;k<rotateN;k++){
                    int temp=circle[i][0];
                    for(int j=0;j<M-1;j++){
                        circle[i][j]=circle[i][j+1];
                    }
                    circle[i][M-1]=temp;
                }

            }
        }
    }

    static boolean delete(){
        boolean isDelete=false;
        for(int y=1;y<=N;y++){
            for(int x=0;x<M;x++){
                if(circle[y][x]==0) continue;
                deleteNum.add(new int[]{y,x});
                bfs(y, x);
                if(deleteNum.size()>1){
                    int size=deleteNum.size();
                    for(int i=0;i<size;i++){
                        int[]location=deleteNum.get(i);
                        circle[location[0]][location[1]]=0;
                    }
                    isDelete=true;
                }
                deleteNum.clear();
            }
        }
        return isDelete;
    }

    static void bfs(int y, int x){
        int index=0;
        visit[y][x]=true;
        while(index<deleteNum.size()){
            int[] location=deleteNum.get(index);
            for(int i=0;i<4;i++){
                int yy=location[0]+dydx[i][0];
                int xx=location[1]+dydx[i][1];
                if(yy<1||yy>N)continue;
                if(xx<0){
                    xx=M-1;
                }else if(xx>=M){
                    xx=0;
                }
                if(visit[yy][xx])continue;
                visit[yy][xx]=true;
                if(circle[yy][xx]==circle[y][x]){
                    deleteNum.add(new int[]{yy,xx});
                }
            }
            index++;
        }
        visit=new boolean[N+1][M];
    }


    static void changeNum(){
        getSum();
        double avg=sum/(double)numCnt;
       // System.out.println("sum: "+sum+" cng: "+numCnt+" avg: "+avg);
        for(int y=1;y<=N;y++){
            for(int x=0;x<M;x++){
                if(circle[y][x]==0) continue;
                if(circle[y][x]>avg){
                    circle[y][x]--;
                }else if(circle[y][x]<avg){
                    circle[y][x]++;
                }
            }
        }
    }

    static void getSum(){
        numCnt=0;
        sum=0;
        for(int y=1;y<=N;y++){
            for(int x=0;x<M;x++){
                if(circle[y][x]>0){
                    numCnt++;
                    sum+=circle[y][x];

                }

            }
        }

    }
}
