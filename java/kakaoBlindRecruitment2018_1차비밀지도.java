public class kakaoBlindRecruitment2018_1차비밀지도 {
    public static void main(String[] args){
        Solution_1차 sol=new Solution_1차();
        int n=5;
        int []arr1={1,20,28,18,11};
        int []arr2={1,1,21,17,28};
        String[] ans=sol.solution(n,arr1,arr2);
        for(int i=0;i<5;i++){
            System.out.println(ans[i]);
        }
    }
}
class Solution_1차 {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = {};
        String resultBinary;
        answer=new String[n];
        for(int i=0;i<n;i++){
            resultBinary=Integer.toBinaryString(arr1[i] | arr2[i]);
            resultBinary=String.format("%"+n+"s", resultBinary);
            resultBinary=resultBinary.replaceAll("1", "#");
            resultBinary=resultBinary.replaceAll("0", " ");
            answer[i]=resultBinary;
        }
        return answer;
    }
}
