package scofe2021;

import java.io.*;
class Main3 {
    static int N;
    static int[][]map;
    static int minY=50,minX=50, maxY, maxX;
    static int answer;
    static int []size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        size=new int[N+1];

        String input;
        for(int y=0;y<N;y++){
            input=br.readLine();
            for(int x=0;x<N;x++){
                map[y][x]=input.charAt(x)-'0';
                if(map[y][x]==1){
                    if(minY>y) minY=y;
                    if(minX>x) minX=x;
                    if(maxY<y) maxY=y;
                    if(maxX<x) maxX=x;
                }
            }
        }

        solution();
        sb.append("total: "+answer+"\n");

        for(int i=1;i<=N;i++){
            if(size[i]==0)break;
            sb.append("size["+i+"]: "+size[i]+"\n");
        }
        System.out.print(sb);
    }
    static void solution(){
        int diffY=maxY-minY+1;
        int diffX=maxX-minX+1;

        int maxSize=diffY<diffX?diffY:diffX;

        for(int s=1;s<=maxSize;s++){
            for(int y=minY;y+s-1<=maxY;y++){
                for(int x=minX;x+s-1<=maxX;x++){
                    if(isValid(y, x, s)){
                        size[s]++;
                    }
                }
            }

            if(size[s]==0)break;
            answer+=size[s];
        }
    }

    static boolean isValid(int startY, int startX, int size){
        for(int y=startY, endY=startY+size;y<endY;y++){
            for(int x=startX,endX=startX+size;x<endX;x++){
                if(map[y][x]!=1){
                    return false;
                }
            }
        }
        return true;
    }
}
