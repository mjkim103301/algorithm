package 백준특강;
import java.math.BigInteger;
import java.util.*;
// java 8에서는 빅인티저 sqrt못씀.... 직접 나눠봐야함...
public class BOJ13709_제곱근 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        BigInteger N=new BigInteger(scan.nextLine());
        BigInteger answer=N.sqrt();
        System.out.println(answer);
    }
}
