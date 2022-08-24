package programmers.level2;

public class PRO_문자열압축 {
    static String shortS="";
    static int minLength;
    public static int solution(String s) {
        minLength=s.length();
        for(int i=1;i<s.length();i++){
            compress(s, i);
            System.out.println(shortS);
            if(minLength>shortS.length()){
                minLength=shortS.length();
            }
        }
        return minLength;
    }

    static void compress(String s, int num){
        shortS="";
        int count=0;
        String target=s.substring(0, num);
        int i=0;
        for(;i+num<=s.length();i+=num){
            String compare=s.substring(i, i+num);
            if(target.equals(compare)){
                count++;
            }else{
                addShortS(count, target);
                target=compare;
                count=1;
            }
        }
        addShortS(count, target);

        if(i<=s.length()){
            shortS+=s.substring(i);
        }
    }

    static void addShortS(int count, String target){
        if(count>1){
            shortS+=count+target;
        }else{
            shortS+=target;
        }
    }

    public static void main(String[] args) {
        int answer=solution("aabbaccc");
        System.out.println(answer);
    }
}
