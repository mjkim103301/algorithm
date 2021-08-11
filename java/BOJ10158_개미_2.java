package baekjoon.level_silver;

import java.util.Scanner;

public class BOJ10158_개미_2 {
    static int w,h;
    static int p,q;
    static int t;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        w=scan.nextInt();
        h=scan.nextInt();
        p=scan.nextInt();
        q=scan.nextInt();
        t=scan.nextInt();

        solution();
        System.out.println(p+" "+q);
    }

    static void solution(){
      p=(p+t)%(2*w);
      q=(q+t)%(2*h);

      if(p>w){
          p=2*w-p;
      }
      if(q>h){
          q=2*h-q;
      }

    }
}
