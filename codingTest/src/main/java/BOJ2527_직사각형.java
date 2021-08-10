package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ2527_직사각형 {
    static class Node{
        int x1,y1,x2,y2;
        public Node(int x1,int y1,int x2,int y2){
            this.x1=x1;
            this.y1=y1;
            this.x2=x2;
            this.y2=y2;
        }
    }
    static Node rec1,rec2;
    static char answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<4;i++){
            st=new StringTokenizer(br.readLine());
            rec1=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            rec2=new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            solution();
            sb.append(answer+"\n");

        }
        System.out.println(sb);

    }

    static void solution(){
        if((rec1.x1==rec2.x2 && rec1.y1==rec2.y2)||(rec1.x2==rec2.x1 && rec1.y1==rec2.y2)||(rec1.x2==rec2.x1 && rec1.y2==rec2.y1)||(rec1.x1==rec2.x2 && rec1.y2==rec2.y1)){//점
            answer='c';
        }else if((rec1.x1>=rec2.x2 && rec1.y1>=rec2.y2)||(rec1.x2<=rec2.x1&&rec1.y1>=rec2.y2)||(rec1.x2<=rec2.x1&&rec1.y2<=rec2.y1)||(rec1.x1>=rec2.x2&&rec1.y2<=rec2.y1)){//공통부분 없음
            answer='d';
        }else if((rec1.x1>rec2.x2)||(rec1.y1>rec2.y2)||(rec1.x2<rec2.x1)||(rec1.y2<rec2.y1)){
            answer='d';
        }else if((rec1.x1==rec2.x2)||(rec1.y1==rec2.y2)||(rec1.x2==rec2.x1)||(rec1.y2==rec2.y1)){//선
            answer='b';
        }else {//직사각형
            answer='a';
        }
    }
}
