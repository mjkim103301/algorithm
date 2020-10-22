import java.util.*;
public class sort_K번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int length=commands.length;
        int[] answer = new int[length];
        Vector<Integer> v=new Vector<>();
        Vector<Integer> ans=new Vector();

        for(int[] item:commands){
            for(int i=item[0]-1;i<=item[1]-1;i++){
                v.add(array[i]);
            }
           Collections.sort(v);

            ans.add(v.elementAt(item[2]-1));
            v.removeAllElements();
        }

        int index=0;
        for(Integer item: ans){
            answer[index++]=item;
        }
        return answer;
    }
    public static void main(String[] args){
       int[] array={1, 5, 2, 6, 3, 7, 4};
       int [][] commands={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer=solution(array, commands);
        for( int item:answer){
            System.out.println(item);
        }

    }
}
