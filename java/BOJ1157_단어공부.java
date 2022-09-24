package baekjoon.level_bronze;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1157_단어공부 {
    static int[] alphabet;
    static List<Integer> maxList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        input=input.toUpperCase();
        alphabet=new int[30];

        for(int i=0;i<input.length();i++){
            int index= input.charAt(i)-'A';
            alphabet[index]++;
        }

        int maxCount=0;
        for(int i=0;i<30;i++){
            if(alphabet[i]>maxCount){
                maxCount=alphabet[i];
                maxList.clear();
                maxList.add(i);
            }else if(alphabet[i]==maxCount){
                maxList.add(i);
            }
        }

        if(maxList.size()>1){
            System.out.println("?");
        }else{
            System.out.println((char)(maxList.get(0)+'A'));
        }

    }
}
