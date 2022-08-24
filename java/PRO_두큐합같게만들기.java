package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class PRO_두큐합같게만들기 {
    static Queue<Integer> first=new LinkedList<>();
    static Queue<Integer> second=new LinkedList<>();
    static long sumFirst, sumSecond;
    static int max;
    public int solution(int[] queue1, int[] queue2) {
        setQueue(queue1, queue2);
        max=queue1.length*4;
        int answer=0;
        while(sumFirst!=sumSecond){
            int move=0;
            answer++;
            if(sumFirst>sumSecond){
                move=first.poll();
                sumFirst-=move;
                second.offer(move);
                sumSecond+=move;
            }else{
                move=second.poll();
                sumSecond-=move;
                first.offer(move);
                sumFirst+=move;
            }

            if(answer>max){
                return -1;
            }
        }
        return answer;
    }
    static void setQueue(int[] queue1, int[] queue2) {
        for(int item:queue1){
            sumFirst+=item;
            first.offer(item);
        }
        for(int item:queue2){
            sumSecond+=item;
            second.offer(item);
        }
    }
}
