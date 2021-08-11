package baekjoon.level_silver;

import java.io.*;
import java.util.*;

public class BOJ10814_나이순정렬 {
    static int N;
    static class Node{
        int id;
        int age;
        String name;
        public Node(int id,int age, String name){
            this.id=id;
            this.age=age;
            this.name=name;
        }
    }
    static Node[] member;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());

        member=new Node[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            member[i]=new Node(i,Integer.parseInt(st.nextToken()), st.nextToken() );
        }

        Arrays.sort(member, new Comparator<Node>(){

            @Override
            public int compare(Node o1, Node o2) {
                if(o1.age!=o2.age){
                    return o1.age-o2.age;
                }
                return o1.id-o2.id;
            }
        });

        for(int i=0;i<N;i++){
            bw.write(member[i].age+" "+member[i].name+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
