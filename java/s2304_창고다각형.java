package baekjoon.silver;
import java.util.*;
import java.io.*;

public class s2304_창고다각형 {
    static int N;
    static class Node{
        int L,H;
        public Node(int L, int H){
            this.L=L;
            this.H=H;
        }
    }
    static ArrayList<Node> sticks=new ArrayList<>();
    static int maxH, maxHL, maxHLIndex;
    static Stack<Node> left=new Stack<>();
    static Stack<Node> maxHAndRight=new Stack<>();
    static int area;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            if(maxH<h){
                maxH=h;
                maxHL=l;
            }
            sticks.add(new Node(l, h));
        }

        solution();
        System.out.println(area);
    }

    static void solution(){
        sort();
        maxHLIndex=getMaxHLIndex();
        setLeft();
        setmaxHAndRight();
        getArea();
    }

    static void sort(){
        Collections.sort(sticks, (o1, o2)->(o1.L-o2.L));
    }

    static int getMaxHLIndex(){
        for(int i=0;i<N;i++){
            Node now=sticks.get(i);
            if(now.L==maxHL&& now.H==maxH){
                return i;
            }
        }
        return 0;
    }
    static void setLeft(){
        for(int i=maxHLIndex-1;i>=0;i--){
            if(!left.isEmpty()&& left.peek().H<sticks.get(i).H){
                left.pop();
                while(!left.isEmpty()){
                    if(left.peek().H>=sticks.get(i).H){
                        break;
                    }
                    left.pop();
                }
            }
            left.push(sticks.get(i));
        }
    }

    static void setmaxHAndRight(){
        for(int i=maxHLIndex;i<N;i++){
            if(!maxHAndRight.isEmpty()&& maxHAndRight.peek().H<sticks.get(i).H){
                maxHAndRight.pop();
                while(!maxHAndRight.isEmpty()){
                    if(maxHAndRight.peek().H>=sticks.get(i).H){
                        break;
                    }
                    maxHAndRight.pop();
                }
            }
            maxHAndRight.push(sticks.get(i));
        }
    }

    static void getArea(){
        while(!left.isEmpty()){
            Node first=left.pop();
            if(!left.isEmpty()){//아직 남아있을 때
                Node second=left.peek();
                area+=first.H*(second.L-first.L);
            }else{
                area+=first.H*(maxHL-first.L);
            }
        }

        while(!maxHAndRight.isEmpty()){
            Node first=maxHAndRight.pop();
            if(!maxHAndRight.isEmpty()){//아직 남아있을 때
                Node second=maxHAndRight.peek();
                area+=first.H*(first.L-second.L);
            }else{
                area+=first.H;
            }
        }
    }

}
