package programmers.lv3;

// 계속 돌려도 계속 성공함!!!!!

import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Collections;

public class PRO_징검다리_건너기 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static HashMap<Integer, Integer> map = new HashMap<>();

    public int solution(int[] stones, int k) {
        for (int i = 0; i < k; i++) {
            plusToMap(stones[i]);
            pq.add(stones[i]);
        }
        int min = pq.peek();
        int left = 0;
        int stonesLength = stones.length;
        for (int right = k; right < stonesLength; right++) {
            int max = getValue(left++, right, stones);
            if (min > max) {
                min = max;
            }
        }
        return min;
    }

    static int getValue(int left, int right, int[] stones) {
        pq.add(stones[right]);
        plusToMap(stones[right]);
        minusToMap(stones[left]);

        while (!map.containsKey(pq.peek())) {
            pq.poll();
        }
        return pq.peek();
    }

    static void plusToMap(int target) {
        if (map.containsKey(target)) {
            map.put(target, map.get(target) + 1);
        } else {
            map.put(target, 1);
        }
    }

    static void minusToMap(int target) {
        if (map.containsKey(target)) {
            int value = map.get(target);
            if (value == 1) {
                map.remove(target);
                return;
            }
            map.put(target, value - 1);
        }
    }
}

