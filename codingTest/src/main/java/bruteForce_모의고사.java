import java.util.*;
public class bruteForce_모의고사 {
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int[][] people =new int[3][];
        people[0]= new int[]{1, 2, 3, 4, 5};
        people[1]= new int[]{2,1,2,3,2,4,2,5};
        people[2]= new int[]{3,3,1,1,2,2,4,4,5,5};
        int [] correct=new int[3];
        Stack<Integer> stack=new Stack<>();
        int len=answers.length;
        for(int i=0;i<3;i++){
            int pattern=people[i].length;
            for(int j=0;j<len;j++){
                if(people[i][j%pattern]==answers[j]){
                    correct[i]++;
                }
            }
        }
        for(int i=0;i<3;i++){
            int target=correct[i];
            if(stack.empty()){
                stack.add(i+1);
            }else{
                if(correct[stack.peek()-1]<target){
                    stack.removeAllElements();
                    stack.add(i+1);
                }else if(correct[stack.peek()-1]==target){
                    stack.add(i+1);
                }
            }
        }
        int size=stack.size();
        answer=new int[size];
        for(int i=0;i<size;i++){
            answer[i]=stack.peek();
            stack.pop();
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args){
        //int[] answers={1,2,3,4,5};
        int[] answers={1,3,2,4,2};
        int [] ans=solution(answers);
        for(Integer item:ans){
            System.out.print(item+" ");
        }
    }
}
