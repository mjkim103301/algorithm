public class kakaoBlindRecruitment2020_괄호변환 {
    public static int isValid(String target, int len){
        int openCnt=0, closeCnt=0;
        for(int i=0;i<len;i++){
            if(target.charAt(i)=='('){
                openCnt++;
            }else{
                closeCnt++;
            }
            if(openCnt<closeCnt){
                return 0;
            }
        }
        return 1;
    }
    public static int findMid(String p, int start){
        int openCnt=0, closeCnt=0;
        int len=p.length();
        int index=start;
        while(index<=start||(openCnt!=closeCnt && index<len)){
            if(p.charAt(index)=='('){
                openCnt++;
            }else{
                closeCnt++;
            }
            index++;
        }
        return index;
    }
    static String aans="";
    public static void mergeSort(String p, int start, int end){
        if(start>=end){
            return;
        }else if(start+1==end){
            aans+="()";
            return;
        }
        int mid=findMid(p, start);
        String u=p.substring(start, mid);
        int uLen=u.length();
        if(isValid(u, uLen)==0){
            aans+="(";
            mergeSort(p, mid, end);
            aans+=")";

            for(int i=1;i<uLen-1;i++){
                if(u.charAt(i)=='('){
                    aans+=")";
                }else{
                    aans+="(";
                }
            }
        }else{
            aans+=u;
            mergeSort(p, mid, end);
        }
    }
    public static String solution(String p) {
        String answer = "";
        int pLen=p.length();
        mergeSort(p, 0, pLen-1);
        answer=aans;
        return answer;
    }
    public static void main(String []args){
        String p=")(";
       p="(()())()";
        p="()))((()";
        String ans=solution(p);
        System.out.println(ans);
    }
}
