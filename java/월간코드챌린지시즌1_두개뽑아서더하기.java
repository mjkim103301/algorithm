import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

class Solution3 {
    HashSet<Integer> set=new HashSet<>();
    ArrayList<Integer> list=new ArrayList<>();
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int size=numbers.length;
        int temp=0;

        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                temp=numbers[i]+numbers[j];
                set.add(temp);
            }
        }
        Iterator iter=set.iterator();
        while(iter.hasNext()){
            list.add((Integer) iter.next());
        }
        Collections.sort(list);
        int listSize=list.size();
        answer=new int[listSize];
        for(int i=0;i<listSize;i++){
            answer[i]=list.get(i);
        }

        return answer;
    }
}

public class 월간코드챌린지시즌1_두개뽑아서더하기{
    public static void main(String[] args){
        Solution3 sol=new Solution3();
        int [] numbers={2,1,3,4,1};
        int [] ans;
        ans=sol.solution(numbers);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }

}