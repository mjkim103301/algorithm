package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500_테트로미노 {
    static int N,M;
    static int [][]map;
    static int minY,minX,maxY,maxX;
    static int[][][]tetromino={
            {
                    {0,0,0,0},
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,1,0,0}
            },
            {
                    {0,0,0,0},
                    {1,0,0,0},
                    {1,1,0,0},
                    {0,1,0,0}
            },
            {
                    {0,0,0,0},
                    {0,0,0,0},
                    {1,1,1,0},
                    {0,1,0,0}
            },
            {
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
                    {1,1,1,1}
            },
            {
                    {0,0,0,0},
                    {0,0,0,0},
                    {1,1,0,0},
                    {1,1,0,0}
            }
    };
    static int[][] rotate(int[][] tet){
        int height= tet[0].length;
        int width=tet.length;

        int[][]temp=new int[height][width];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                temp[y][x]=tet[width-1-x][y];
            }
        }
        return temp;
    }
    static int[][]trim(int[][]tet){
        minY=4;minX=4;maxY=0;maxX=0;
        for(int y=0;y<4;y++){
            for(int x=0;x<4;x++){
                if(tet[y][x]==1){
                    if(y<minY)minY=y;
                    if(x<minX)minX=x;
                    if(y>maxY)maxY=y;
                    if(x>maxX)maxX=x;
                }
            }
        }
        int height=maxY-minY+1;
        int width=maxX-minX+1;
        int [][]compact=new int[height][width];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                compact[y][x]=tet[minY+y][minX+x];
            }
        }
        return compact;
    }
    static int[][] flip(int[][]compact){
        int height= compact.length;
        int width=compact[0].length;
        int [][]result=new int[height][width];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                result[y][x]=compact[y][width-1-x];
            }
        }
        return result;
    }
    static int check(int[][]target){
        int height= target.length;
        int width=target[0].length;
        int sum=0;
        int max=0;
        for(int mapY=0;mapY<N-height+1;mapY++){
            for(int mapX=0;mapX<M-width+1;mapX++){
                for(int y=0;y<height;y++){
                    for(int x=0;x<width;x++){
                        if(target[y][x]==1){
                            sum+=map[mapY+y][mapX+x];
                        }
                    }
                }
                max=Math.max(max, sum);
                sum=0;
            }
        }


        return max;
    }
    static int findMax(int tetIndex){
        int max=0;
        int[][]tet=tetromino[tetIndex];
        tet=trim(tet);
        for(int i=0;i<4;i++){
            int temp=check(tet);
            max=Math.max(max, temp);

            tet=flip(tet);
            temp=check(tet);
            max=Math.max(max, temp);

            tet=flip(tet);
            tet=rotate(tet);
        }
        return max;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []size=(br.readLine()).split(" ");
        StringTokenizer st;
        N=parse(size[0]);
        M=parse(size[1]);
        int max=0;
        map=new int[N][M];
        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<M;x++) {
                map[y][x] = parse(st.nextToken());
            }
        }
        for(int i=0;i<5;i++){
            int sum=findMax(i);
            max=Math.max(max,sum);
        }
        System.out.println(max);
    }
    static int parse(String s){
        return Integer.parseInt(s);
    }
}
