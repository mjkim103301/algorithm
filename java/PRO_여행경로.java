package bundang.algo.study.week2;

import java.util.*;
class PRO_여행경로 {
    static Set<String> citys=new HashSet<>();
    static List<String> sortedCity=new ArrayList<>();
    static int[][] map;
    static List<Integer>way=new ArrayList<>();
    static int W, H;
    static String[]answer;
    public String[] solution(String[][] tickets) {
        setCitys(tickets);
        setMap(tickets);
        way.add(sortedCity.indexOf("ICN"));
        dfs(1, sortedCity.indexOf("ICN"), tickets, map);
        return answer;
    }

    static void setCitys(String[][] tickets){
        H=tickets.length;
        W=tickets[0].length;
        for(int y=0;y<H;y++){
            for(int x=0;x<W;x++){
                citys.add(tickets[y][x]);
            }
        }

        sortedCity=new ArrayList<>(citys);
        Collections.sort(sortedCity);
    }

    static void setMap(String[][] tickets){
        map=new int[sortedCity.size()][sortedCity.size()];
        for(int y=0;y<H;y++){
            String from=tickets[y][0];
            String to=tickets[y][1];
            int fromIndex = sortedCity.indexOf(from);
            int toIndex=sortedCity.indexOf(to);
            map[fromIndex][toIndex]++;
        }
    }
    static boolean stop=false;
    static void dfs(int cnt, int startIndex, String[][] tickets, int[][] innerMap){
        if(cnt==H+1){
            stop=true;
            answer = new String[way.size()];
            for(int i=0;i<way.size();i++){
                answer[i]=sortedCity.get(way.get(i));
            }
            return;
        }
        for(int x=0;x<sortedCity.size();x++){

            if(innerMap[startIndex][x]>0){
                way.add(x);
                innerMap[startIndex][x]--;
                dfs(cnt+1, x, tickets, innerMap);
                if(stop){
                    return;
                }
                way.remove(way.size()-1);
                innerMap[startIndex][x]++;
            }
        }
    }
}
