public class techCourse_3 {
    public static String solution(String word){
        String result="";
        int len=word.length();
        for(int i=0;i<len;i++){
            char target=word.charAt(i);
            if(target>='A' && target<='Z'){
                int dif=target-'A';
                result+=(char)('Z'-dif);
            }
            else if(target>='a' && target<='z'){
                int dif=target-'a';
                result+=(char)('z'-dif);
            }else{
                result+=target;
            }
        }
        return result;
    }
    public static void main(String [] args){
        String word="";
        word="I love you!!";
        String ans=solution(word);
        System.out.println(ans);

    }
}
