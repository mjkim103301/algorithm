import java.util.Collections;
import java.util.PriorityQueue;
public class heap_더_맵게 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int size=scoville.length;
        PriorityQueue<Integer> minHeap=new PriorityQueue();
        for(int i=0;i<size;i++){
            minHeap.offer(scoville[i]);
        }
        while(minHeap.peek() < K){
            if(minHeap.size()<2) return -1;
            else{
                int min=minHeap.poll();
                int nextMin=minHeap.poll();
                int input=mix(min, nextMin);
                minHeap.add(input);

                answer++;
            }
        }
        return answer;
    }
    public static int mix(int min, int nextMin){
        return min+nextMin*2;
    }
    public static void main(String[] args){
        int[] scoville={1,2,3,9,10,12};
        int answer=solution(scoville, 7);
        System.out.println(answer);
    }
}
