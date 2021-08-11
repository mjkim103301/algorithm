package level2;

import java.util.*;

public class kakaoCodeWinterInternship_tuple {
    public static void main(String[]args){
        Solution_tuple sol=new Solution_tuple();
        String s="{{2},{2,1},{2,1,3},{2,1,3,4}}";
        s="{{1,2,3},{2,1},{1,2,4,3},{2}}";
        s="{{20,111},{111}}";
        int [] answer=sol.solution(s);
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }

}

class Solution_tuple {
    HashMap<String, Integer> map=new HashMap<>();
    public int[] solution(String s) {
        int[] answer = {};
        String []str=s.replaceAll("[{}]", " ").trim().split(" , ");
        Arrays.sort(str, (a,b)->(a.length()-b.length()));
        int strSize=str.length;
        answer=new int[strSize];

        for(int i=0;i<strSize;i++){
            String []temp=str[i].split(",");
            int tempSize=temp.length;
            for(int j=0;j<tempSize;j++){
                String num=temp[j];
                if(!map.containsKey(num)){
                    answer[i]=Integer.parseInt(num);
                    map.put(num, 1);
                }
            }

        }
        return answer;
    }
}
/*
class Solution_tuple {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> child = new ArrayList<>();
    ArrayList<ArrayList<Integer>> parent = new ArrayList<>();

    void split(String s) {
        int len = s.length();
        StringBuffer numString = new StringBuffer();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numString.append(ch);

            } else if (ch == ',') {
                if (numString.length()==0) {
                   continue;
                }
                child.add(Integer.parseInt(String.valueOf(numString)));
                numString = new StringBuffer();
            } else if (ch == '}') {
                if (numString.length()==0) {
                    return;
                }
                child.add(Integer.parseInt(String.valueOf(numString)));
                numString = new StringBuffer();
                parent.add((ArrayList<Integer>) child.clone());
                child.clear();
            }
        }
    }

    void sort() {
        Collections.sort(parent, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
    }

    public int[] solution(String s) {
        int[] answer = {};

        split(s);
        sort();
        int parentSize = parent.size();
        int answerIndex = 0;
        answer = new int[parentSize];
        for (int i = 0; i < parentSize; i++) {
            int childSize = parent.get(i).size();
            for (int j = 0; j < childSize; j++) {
                int target = parent.get(i).get(j);
                if (!map.containsKey(target)) {
                    answer[answerIndex++] = target;
                    map.put(target, 1);
                }
            }
        }
        return answer;
    }
}*/
