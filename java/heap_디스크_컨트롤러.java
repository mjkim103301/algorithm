
import java.util.*;

  class Node {
          int input;
          int length;
  }

public class heap_디스크_컨트롤러 {

        public static int solution(int[][] jobs) {
            int answer = 0;
            int time=0;
            int index=0;
            int length=jobs.length;
           PriorityQueue<int []> minHeap=new PriorityQueue<>((i1, i2)->(i1[1]-i2[1]));
            Arrays.sort(jobs, (i1, i2)->(i1[0]-i2[0]));
            while(index<length || !minHeap.isEmpty()) {
                while (index<length&& jobs[index][0] <= time) {//작업시작
                    minHeap.add(jobs[index++]);
                }
                if(minHeap.isEmpty()){

                    time=jobs[index][0];
                }else{
                    int temp[]=minHeap.peek();
                    answer+=(time-temp[0]+temp[1]);
                    time+=temp[1];
                    minHeap.remove();
                }

            }
            return answer/length;
        }

    public static void main(String[] args){
//        int[][] jobs={{0, 3},{1,9},{2,6}};
        int[][] jobs={{0, 10},{4,10},{5,11}, {15, 2}};

        int answer=solution(jobs);
        System.out.println(answer);
    }
}
