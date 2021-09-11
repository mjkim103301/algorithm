package kakao2021하반기;
import java.util.*;

public class Solution1 {
    static boolean[][] reportMap;
    static HashMap<String, Integer> indexMap=new HashMap<>();
    static int[] reportedCount;
    static int idListSize, reportSize;
    static int[] answer;
    public static void main(String[] args) {
        String[] id_list ={"muzi", "frodo", "apeach", "neo"};
        String[] report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;
        int[] ans=solution(id_list, report, k);

        for(int i=0;i<idListSize;i++){
            System.out.print(answer[i]+" ");
        }
    }

    static public int[] solution(String[] id_list, String[] report, int k) {
        idListSize=id_list.length;
        reportSize=report.length;
        answer =new int[idListSize];
        reportedCount=new int[idListSize];
        reportMap=new boolean[idListSize][idListSize];

        //id_list, index 연결
        linkIdListAndIndex(id_list);

        //신고당한 사람 기준으로 누가 신고했는지 조사
        setReportMap(report);

        //reportedCount배열돌면서 k 이상이면 answer배열에 값 추가
        setAnswer(k);
        return answer;
    }

    static void linkIdListAndIndex(String[] id_list){
        for(int i=0;i<idListSize;i++){
            indexMap.put(id_list[i], i);
        }
    }

    static void setReportMap(String[] report){
        for(int i=0;i<reportSize;i++){
            String target=report[i];
            int blankIndex=target.indexOf(" ");
            String from=target.substring(0,blankIndex);
            String to=target.substring(blankIndex+1);
            int fromIndex=indexMap.get(from);
            int toIndex=indexMap.get(to);

            if(!reportMap[toIndex][fromIndex]){
                reportMap[toIndex][fromIndex]=true;
                reportedCount[toIndex]++;
            }
        }

//        for(int y=0;y<idListSize;y++){
//            System.out.println(y+"index reportedcount: "+reportedCount[y]);
//            for(int x=0;x<idListSize;x++){
//                System.out.print(reportMap[y][x]+" ");
//            }
//            System.out.println();
//            System.out.println();
//        }
    }

    static void setAnswer(int k){
        for(int i=0;i<idListSize;i++){
            if(reportedCount[i]>=k){
                for(int j=0;j<idListSize;j++){
                    if(reportMap[i][j]){
                        answer[j]++;
                    }
                }
            }
        }
    }


}
