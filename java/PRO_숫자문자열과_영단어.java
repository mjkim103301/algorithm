package programmers.level1;

import java.util.*;

public class PRO_숫자문자열과_영단어 {
    static HashMap<String, Integer> map = new HashMap<>();

    public static int solution(String s) {
        String answer="";
        init();
        String word="";
        for(int i=0;i<s.length();i++){
            char now=s.charAt(i);
            switch (now){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    answer+=now;
                    break;
                default:
                    word+=now;
            }
            if(map.containsKey(word)){
                answer+=map.get(word);
                word="";
            }
        }
        return Integer.parseInt(answer);
    }

    static void init() {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }


    public static void main(String[] args) {
        int answer=solution(	"one4seveneight");
        System.out.println(answer);
    }


}
