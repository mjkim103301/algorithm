package 백준특강;

import java.util.*;
//java8에서는 tempS1.toString().equals(tempS2.toString()) 해야함....
public class BOJ12871_무한문자열 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input1 = scan.nextLine();
        String input2 = scan.nextLine();
        boolean result = solution(input1, input2);
        System.out.println(result ? 1 : 0);
    }

    static boolean solution(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        StringBuilder tempS1 = new StringBuilder();
        StringBuilder tempS2 = new StringBuilder();
        if (s1.contains(s2) && size1 == size2) return true;

        for (int i = 0; i < size2; i++) {
            tempS1.append(s1);
        }
        for (int i = 0; i < size1; i++) {
            tempS2.append(s2);
        }
       if(tempS1.compareTo(tempS2)==0){
           return true;
       }
        return false;
    }
}
