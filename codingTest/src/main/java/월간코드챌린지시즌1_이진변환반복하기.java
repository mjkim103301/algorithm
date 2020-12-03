public class 월간코드챌린지시즌1_이진변환반복하기 {
    public static String getLenToB(String temp){
        int len=temp.length();
        String Binary="";
        String returnB="";
        while(len>=2){
            Binary+=len%2;
            len/=2;
        }
        Binary+=len;
        for(int i=Binary.length()-1;i>=0;i--){
            returnB+=Binary.charAt(i);
        }
        return  returnB;
    }
    public static int[] solution(String s) {
        int[] answer = {0,0};
        int cnt=0;
        int removeZeroCnt=0;
        String target=s;
        while(!target.equals("1")){
            String temp="";
            int len=target.length();
            for(int i=0;i<len;i++){
                if(target.charAt(i)=='1'){
                    temp+=target.charAt(i);
                }else{
                    removeZeroCnt++;
                }
            }
            target=getLenToB(temp);
            cnt++;
        }
        answer[0]=cnt;
        answer[1]=removeZeroCnt;
        return answer;
    }
    public static void main(String[]args){
        String a="110010101001";
        int [] ans=solution(a);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
