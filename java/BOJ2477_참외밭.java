package baekjoon.level_silver;

import java.util.*;

public class BOJ2477_참외밭 {
    static int K;
    static int outY,outX,inY,inX;
    static class Node{
        int direct;
        int distance;
        public Node(int direct, int distance){
            this.direct=direct;
            this.distance=distance;
        }
    }
    static Node[] farm;
    static int orientalMelon;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        K=scan.nextInt();

        farm=new Node[6];

        for(int i=0;i<6;i++){
            farm[i]=new Node(scan.nextInt(), scan.nextInt());
        }
        solution();
        System.out.println(orientalMelon);
    }

    static void solution(){
        int lastDirect=0;
        for(int i=0;i<6;i++){
            Node now=farm[i];
            switch(now.direct){
                case 1:
                    if(i>0 && lastDirect!=3){
                        inY=farm[i-1].distance;
                        inX=now.distance;
                    }else{
                        outX=Math.max(outX, now.distance);
                    }
                    break;
                case 2:
                    if(i>0 && lastDirect!=4){
                        inY=farm[i-1].distance;
                        inX=now.distance;
                    }else{
                        outX=Math.max(outX, now.distance);
                    }
                    break;
                case 3:
                    if(i>0 && lastDirect!=2){
                        inX=farm[i-1].distance;
                        inY=now.distance;
                    }else{
                        outY=Math.max(outY, now.distance);
                    }
                    break;
                case 4:
                    if(i>0 && lastDirect!=1){
                        inX=farm[i-1].distance;
                        inY=now.distance;
                    }else{
                        outY=Math.max(outY, now.distance);
                    }
                    break;

            }
            lastDirect=now.direct;

        }
        if(inY==0 && inX==0){
            if(farm[0].direct==1 || farm[0].direct==2){
                inX=farm[0].distance;
                inY=farm[5].distance;
            }else{
                inX=farm[5].distance;
                inY=farm[0].distance;
            }
        }
        int area=(outY*outX)-(inY*inX);
        orientalMelon=area*K;
    }
}
