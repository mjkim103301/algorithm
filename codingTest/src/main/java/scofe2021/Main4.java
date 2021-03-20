package scofe2021;

import java.io.*;
import java.util.*;
class Main4 {
    static class Node{
        char state;
        int scoreIndex;
        int index;
        public Node(char state, int scoreIndex, int index){
            this.state=state;
            this.scoreIndex=scoreIndex;
            this.index=index;
        }
    }
    static float[]score=new float[5];
    static int N,M;
    static Node[] map;
    static String first="YOW";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<5;i++){
            score[i]=Float.parseFloat(st.nextToken());

        }
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new Node[N*M];
        String input;

        for(int y=0;y<N;y++){
            input=br.readLine();
            for(int x=0;x<M;x++){
                map[y*M+x]=new Node(input.charAt(x), 0, y*M+x);
            }
        }
        for(int y=0;y<N;y++){
            input=br.readLine();
            for(int x=0;x<M;x++){
                int index=input.charAt(x)-'A';
                map[y*M+x].scoreIndex=index;
            }
        }

        solution();
        for(int i=0, end=N*M;i<end;i++){
            Node now=map[i];
            if(map[i].state=='W')break;
            sb.append((char)('A'+now.scoreIndex)+" "+score[now.scoreIndex]+" "+now.index/M+" "+now.index%M+"\n");
        }
        System.out.print(sb);
    }
    static void solution(){
        Arrays.sort(map, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int o2Index=first.indexOf(o2.state);
                int o1Index=first.indexOf(o1.state);
                if(o2Index<o1Index){
                    return 1;
                }else if(o2Index==o1Index){
                    float o2Like=score[o2.scoreIndex];
                    float o1Like=score[o1.scoreIndex];
                    if(o2Like>o1Like){
                        return 1;
                    }else if(o2Like==o1Like){
                        return o1.index-o2.index;
                    }
                    return -1;
                }
                return -1;

            }
        });
    }
}
