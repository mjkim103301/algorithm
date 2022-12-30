package baekjoon.silver;

import java.math.BigInteger;
import java.util.*;

public class BOJ2407_조합 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int M=scan.nextInt();

        BigInteger n= BigInteger.ONE;
        BigInteger m= BigInteger.ONE;

        for(int i=1;i<=M;i++){
            n=n.multiply(BigInteger.valueOf(N-i+1));
            m=m.multiply(BigInteger.valueOf(i));
        }
        System.out.print(n.divide(m));
    }
}
