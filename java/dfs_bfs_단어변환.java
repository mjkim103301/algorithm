import java.util.*;
public class dfs_bfs_단어변환 {
    static class Node{
        String before;
        int level;
        int []visited;
    }

    static Queue<Node> queue=new LinkedList<>();
    static int len;
    static Node newNode(String before, Integer level, int[] visited){
        Node node=new Node();
        node.before=before;
        node.level=level;
        node.visited=visited;
        return node;
    }
    static int BFS(String[] words){
        Node front=queue.peek();
        for(int i=0;i<len;i++){
            int diff=0;

            if(front.visited[i]==1)continue;
            front.visited[i]=1;
            for(int j=0;j<words[i].length();j++){
                if(front.before.charAt(j)!=words[i].charAt(j)){
                    diff++;
                }
                if(diff>1)break;
            }
            if(diff==0){
                return front.level+1;
            }
            if(diff<=2){
                Node node;
                node=newNode(words[i], front.level+1, front.visited);
                queue.add(node);
            }
        }
        return 0;
    }
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        len=words.length;
        int[] visited=new int[len];
        int flag=0;
        for(int i=0;i<len;i++){
            if(words[i].equals(target)){
                flag=1;
                break;
            }
        }
        if(flag==0)return 0;

        Node node;
        node=newNode(begin, 0, visited);
        queue.add(node);
        answer=BFS(words);
        return answer;
    }
    public static void main(String[] args){

    }
}
