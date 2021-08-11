package baekjoon.level_silver;

import java.math.BigInteger;
import java.util.*;

public class BOJ1793_타일링 {
    static long cnt;
    static int N;
    static BigInteger[]tile;
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);

        tile=new BigInteger[1001];
        solution();
        while (scan.hasNextInt()) {

            N = scan.nextInt();
            System.out.println(tile[N].remainder(new BigInteger("10007")));
        }

    }



    static void solution(){
        tile[0]=new BigInteger("1");
        tile[1]=new BigInteger("1");
        tile[2]=new BigInteger("3");
        for(int i=3;i<=1000;i++){
            tile[i]=(tile[i-2].multiply(new BigInteger("2"))).add(tile[i-1]);
        }
    }


}
