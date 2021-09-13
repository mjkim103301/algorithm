package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ2628_종이자르기 {
    static int W,H;
    static int cnt;
    static ArrayList<Integer> row=new ArrayList<>();
    static ArrayList<Integer> height=new ArrayList<>();
    static int maxY, maxX, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        W=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        cnt=Integer.parseInt(br.readLine());
        for(int i=0;i<cnt;i++){
            st=new StringTokenizer(br.readLine());
            int direct=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());
            if(direct==0){
                height.add(num);
            }else{
                row.add(num);
            }
        }

        solution();
        System.out.println(answer);
    }

    static void solution(){
        row.add(0);
        row.add(W);
        height.add(0);
        height.add(H);
        Collections.sort(row);
        Collections.sort(height);
        findMaxYAndX();
        answer=maxX*maxY;
    }

    static void findMaxYAndX(){
        int rowSize=row.size();
        int heightSize=height.size();

        for(int i=1;i<rowSize;i++){
            int diff=row.get(i)-row.get(i-1);
            if(diff>maxX){
                maxX=diff;
            }
        }
        for(int i=1;i<heightSize;i++){
            int diff=height.get(i)-height.get(i-1);
            if(diff>maxY){
                maxY=diff;
            }
        }
    }
}
