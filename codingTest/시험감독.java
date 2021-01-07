package baekjoon;

import java.util.Scanner;

public class 시험감독 {
    public static void main(String [] args){
        Solution_시험감독 sol=new Solution_시험감독();
        Scanner scan=new Scanner(System.in);
        int N;
        int [] A;
        int B,C;
        N=scan.nextInt();
        A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=scan.nextInt();
        }
        B=scan.nextInt();
        C=scan.nextInt();

        long ans=sol.solution(N, A, B, C);
        System.out.println(ans);
    }
}
class Solution_시험감독{
    public long solution(int N, int[]A, int B, int C){
        long inspector=0;
        for(int i=0;i<N;i++){
            int student=A[i];
            student-=B;
            inspector++;
            if(student>0){
                int add=student/C;
                if(student%C!=0){
                    add++;
                }
                inspector+=add;
            }
        }
        return inspector;
    }

}
