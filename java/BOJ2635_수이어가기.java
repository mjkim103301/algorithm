package baekjoon.level_silver;

import java.util.*;

public class BOJ2635_수이어가기 {
    static int num;
    static List<Integer> list=new ArrayList<>();
    static List<Integer> answer=new ArrayList<>();
    static int maxSize=2;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        num=scan.nextInt();
        solution();
        sb.append(answer.size()+"\n");

        for(Integer item:answer){
           sb.append(item+" ");
        }
        System.out.println(sb);
    }

    static void solution(){
        for(int i=num;i>0;i--){
            list.clear();
            list.add(num);
            list.add(i);
            makeNums();
        }
    }

    static void makeNums(){
        int index=0;
        int first=list.get(index++);
        int second=list.get(index);
        while(first-second>=0){
            list.add(first-second);
            first=list.get(index++);
            second=list.get(index);
        }
        if(list.size()>maxSize){
            maxSize=list.size();
            answer.clear();
            answer.addAll(list);
        }
    }
}
