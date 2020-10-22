import java.util.*;
public class sort_HIndex {
    public static int solution(int[] citations) {
        int answer = 0;
        int len=citations.length;
        Integer []cit=new Integer[len];
        for(int i=0;i<len;i++){
            cit[i]=citations[i];
        }
        Arrays.sort(cit, Collections.reverseOrder());
        int target=cit[0];
        int index=0;
       while(true){
           if(target<=cit[index] && index+1>=target){
               answer=target;
               break;
           }
           target--;
           if(index<len-1 && target<=cit[index+1]){
               index++;
           }
       }
        return answer;
    }
    public static void main(String[] args){
        //int[] citations={3,0,6,1,5};
        //int[] citations={10,9,4,1,1};
        int[] citations={10,11,12,13};
        int ans=solution(citations);
        System.out.println(ans);
    }
}
