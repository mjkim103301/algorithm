package ssafy.algo.study.week03;

import java.util.*;

public class BOJ2370_시장선거포스터 {
    static class Node{
        int left,right;
        public Node(int left, int right){
            this.left=left;
            this.right=right;
        }
    }
    static int N;
    static Node[] posters; //입력으로 주어지는 포스터 정보
    static Set<Integer> set=new HashSet<>();
    static int[] attach; // 중복제거한 페이지 저장하는 배열
    static int[] overlap; // 부착된 페이지 기록하는 배열

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        posters=new Node[N];

        for(int i=0;i<N;i++){
            int left=scan.nextInt();
            int right=scan.nextInt();
            posters[i]=new Node(left, right);
            set.add(left);
            set.add(right);
        }

        solution();
        System.out.print(set.size());
    }

    static void solution(){
        int size=set.size();
        attach=new int[size];
        overlap=new int[size];

        //중복 제거한 페이지 번호를 attach 배열에 저장
        int index=0;
        for(int item:set){
            attach[index++]=item;
        }

        //페이지 번호 오름차순으로 정렬
        Arrays.sort(attach);

        // attach[j] 값이 posters[i] 의 left, right 범위 내부에 있다면
        // overlap[j] 에 i 기록
        // i=0 인 포스터는 다 0을 기록했다고 생각함 -> i=1 부터 비교
        for(int i=1;i<N;i++){
            Node now=posters[i];
            for(int j=0;j<size;j++){
                if(attach[j]>=now.left && attach[j]<=now.right){
                    overlap[j]=i;
                }else if(attach[j]>now.right){
                    break;
                }
            }
        }
        set.clear();

        //기록된 페이지의 번호 중복제거
        for(int item:overlap){
            set.add(item);
        }

    }
}
