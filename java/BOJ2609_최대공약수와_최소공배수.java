package baekjoon.bronze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2609_최대공약수와_최소공배수 {
    static int num1, num2;
    static List<Integer> valueList=new ArrayList<>();
    static List<Integer> remainList=new ArrayList<>();
    static int maxPrimeNumber=1, minMultipleNumber=1;
    static boolean []primeNumber;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        num1=scan.nextInt();
        num2=scan.nextInt();
        solution();
        System.out.println(maxPrimeNumber);
        System.out.println(minMultipleNumber);
    }

    static void solution(){
        primeNumber=new boolean[10001];
        setPrimeNumber();
        setAnswer();
    }

    static void setPrimeNumber(){
        for(int i=2;i<=10000;i++){
            if(isPrimeNumber(i)){
                primeNumber[i]=true;
            }
        }
    }

    static boolean isPrimeNumber(int num){
        int max=(int)Math.sqrt(num);
        for(int i=2;i<=max;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    static void setAnswer(){
        remainList.add(num1);
        remainList.add(num2);
        for(int i=2;i<10001;i++){
            if(primeNumber[i] && i<=num1 && i<=num2 && num1%i==0 && num2%i==0){
                int remain1=remainList.get(0)/i;
                int remain2=remainList.get(1)/i;

                valueList.add(i);
                remainList.clear();
                remainList.add(remain1);
                remainList.add(remain2);
                num1=remain1;
                num2=remain2;
                i=1;
            }else if(i>num1 || i>num2){
                break;
            }
        }


        for(int i=0;i<valueList.size();i++){
            maxPrimeNumber*=valueList.get(i);
            minMultipleNumber*=valueList.get(i);
        }

        for(int i=0;i<remainList.size();i++){
            minMultipleNumber*=remainList.get(i);
        }
    }
}
