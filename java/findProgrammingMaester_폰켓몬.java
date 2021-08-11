package level2;

import java.util.*;

public class findProgrammingMaester_폰켓몬 {
}

class Solution {
    HashMap<Integer, Integer> map=new HashMap<>();

    public int solution(int[] nums) {
        int answer = 0;
        int size=nums.length;
        for(int i=0;i<size;i++){
            map.put(nums[i], 1);
        }
        int mapSize=map.size();
        int pick=size/2;
        if(pick<mapSize){
            answer=pick;
        }else{
            answer=mapSize;
        }
        return answer;
    }
}
