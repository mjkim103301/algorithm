package bundang.algo.study.week06;

import java.util.*;

class PRO_메뉴리뉴얼 {
    static List<char[]> orderList;
    static List<String>[] result;
    static Map<String, Integer> map;

    public static String[] solution(String[] orders, int[] course) {
        orderList = new ArrayList<>();
        result = new List[course.length];
        for (int i = 0; i < course.length; i++) {
            result[i] = new ArrayList<>();
        }
        map = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            orderList.add(orders[i].toCharArray());
            Arrays.sort(orderList.get(i));
            //System.out.println(Arrays.toString(orderList.get(i)));
        }

        for (int i = 0; i < orderList.size(); i++) {
            for (int j = 0; j < course.length; j++) {
                combination(0, 0, orderList.get(i), new boolean[10], course[j]);
            }
        }
        setResult(course);
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < result[i].size(); j++) {
                answerList.add(result[i].get(j));
            }
        }
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    static void combination(int level, int next, char[] array, boolean[] used, int N) {
        if (level == N) {
            inputToMap(array, used);
            return;
        }
        for (int i = next; i < array.length; i++) {
            used[i] = true;
            combination(level + 1, i + 1, array, used, N);
            used[i] = false;
        }
    }

    static void inputToMap(char[] array, boolean[] used) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (used[i]) {
                sb.append(array[i]);
            }
        }
        String key = sb.toString();
        if (map.containsKey(key)) {
            int count = map.get(key);
            map.put(key, count + 1);
            return;
        }
        map.put(key, 1);
    }

    static void setResult(int[] course) {
        //System.out.println(map);
        List<Integer> indexList = new ArrayList<>();
        for (int item : course) {
            indexList.add(item);
        }

        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count <= 1) {
                continue;
            }
            int resultIndex = indexList.indexOf(key.length());
            if (result[resultIndex].size() > 0 && map.get(result[resultIndex].get(0)) > count) {
                continue;
            }
            if (result[resultIndex].size() > 0 && map.get(result[resultIndex].get(0)) < count) {
                result[resultIndex].clear();
            }
            result[resultIndex].add(key);
        }


    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] answer = solution(orders, course);
        System.out.println(Arrays.toString(answer));
    }
}