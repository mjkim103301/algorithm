package programmers.level1;

public class PRO_숫자문자열과_영단어2 {
    public static int solution(String s){
        String []alphabet={"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String answer=s;
        for(int i=0;i<10;i++){
            answer=answer.replaceAll(alphabet[i], i+"");
        }

        return Integer.parseInt(answer);
    }
}
