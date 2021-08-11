package baekjoon.level_bronze;

import java.util.*;

public class BOJ13300_방배정 {
    static class Node{
        int girl,boy;
        public Node(){}
        public Node(int girl, int boy){
            this.girl=girl;
            this.boy=boy;
        }
    }
    static Node[]students;
    static int K, rooms;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int N=scan.nextInt();
        K=scan.nextInt();
        students=new Node[7];
        for(int grade=1;grade<=6;grade++){
            students[grade]=new Node();
        }

        for(int i=0;i<N;i++){
            int gender=scan.nextInt();
            int grade=scan.nextInt();

            switch(gender){
                case 0:
                    students[grade].girl++;
                    break;
                case 1:
                    students[grade].boy++;
                    break;
            }

        }
        solution();
        System.out.print(rooms);
    }

    static void solution(){
        for(int grade=1;grade<=6;grade++){
            int girl=students[grade].girl;
            int boy=students[grade].boy;
            rooms+=girl/K;
            rooms+=boy/K;
            if(girl>0 && girl%K!=0){
                rooms++;
            }
            if(boy>0 && boy%K!=0){
                rooms++;
            }
        }
    }
}
