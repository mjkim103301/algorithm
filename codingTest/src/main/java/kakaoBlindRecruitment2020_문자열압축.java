public class kakaoBlindRecruitment2020_문자열압축 {
    public static int splitFunc(String s, int base, int len){
        String temp="";
        String now;
        String rename="";
        int llast=0;
        int cnt=1;
        for(int i=0;i<len;i+=base){
            int last=i+base;
            if(last>len){
                last=len;
            }
            llast=last;
            now=s.substring(i, last);
            if(temp.equals(now)){
                cnt++;
            }else if(temp.equals("")){
                temp=now;
            }else{
                if(cnt>1){
                    rename+=cnt+temp;
                }else{
                    rename+=temp;
                }

                temp=now;
                cnt=1;
            }
        }
        if(llast==len){
            if(cnt>1){
                rename+=cnt+temp;
            }else{
                rename+=temp;
            }

        }else if(llast<len){
            rename+=s.substring(llast);
        }

        return rename.length();
    }
    public static int solution(String s) {
        int answer = 0;
        int min=1000;
        int length=s.length();
        if(length==1){
            return 1;
        }
        int base=length/2;
        for(int i=base;i>0;i--){
            int temp=splitFunc(s, i, length);
            if(min>temp){
                min=temp;
            }
        }
        answer=min;
        return answer;
    }
    public static void main(String [] args){
        String a="aabbaccc";
        a="ababcdcdababcdcd";
        a="abcabcdede";
        a="a";
        int answer=solution(a);
        System.out.println(answer);
    }
}
