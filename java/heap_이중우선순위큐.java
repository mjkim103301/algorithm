import java.util.*;
public class heap_이중우선순위큐 {
    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(String item: operations){
            if(item.charAt(0)=='I'){
                int num=Integer.parseInt(item.substring(2));
                minHeap.add(num);
                maxHeap.add(num);

            }else if(item.charAt(0)=='D'){
                int num=Integer.parseInt(item.substring(2));
                if(num==1 && !maxHeap.isEmpty()){//최댓값 삭제
                    int temp=maxHeap.peek();
                        maxHeap.remove();
                        minHeap.remove(temp);
                }else if(num==-1 && !minHeap.isEmpty()){//최솟값 삭제
                    int temp=minHeap.peek();
                        minHeap.remove();
                    maxHeap.remove(temp);
                }
            }
        }
        int max=0, min=0;
        if(!maxHeap.isEmpty()){
            max=maxHeap.peek();
        }
        if(!minHeap.isEmpty()){
                min=minHeap.peek();
        }
        answer[0]=max;
        answer[1]=min;

        return answer;
    }
    public static void main(String[] args){
        //String[] operations={"I 16", "D 1"};
        String[] operations={"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] answer=solution(operations);
        for( int item:answer){
            System.out.println(item);
        }

    }
}
