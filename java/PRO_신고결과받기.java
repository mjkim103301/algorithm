package programmers.lv1;

import java.util.*;

class PRO_신고결과받기 {
    static HashMap<String, HashSet<String>> reportMap = new HashMap<>();
    static HashMap<String, Integer> reportedNumberMap = new HashMap<>();
    static HashMap<String, Integer> idIndexMap = new HashMap<>();
    static int[] answer;

    public int[] solution(String[] id_list, String[] report, int k) {
        answer = new int[id_list.length];
        init(id_list);
        setReport(report);
        reportedNumber(id_list);
        setAnswer(id_list, k);
        return answer;
    }

    static void init(String[] id_list) {
        int index = 0;
        for (String id : id_list) {
            reportMap.put(id, new HashSet<String>());
            reportedNumberMap.put(id, 0);
            idIndexMap.put(id, index++);
        }
    }

    static void setReport(String[] report) {
        for (String reportCase : report) {
            int index = reportCase.indexOf(" ");
            String name1 = reportCase.substring(0, index);
            String name2 = reportCase.substring(index + 1);
            HashSet<String> reported = reportMap.get(name1);
            reported.add(name2);
            reportMap.put(name1, reported);
        }
    }

    static void reportedNumber(String[] id_list) {
        for (String id : id_list) {
            HashSet<String> reported = reportMap.get(id);
            //System.out.println("id : "+id+", reported: "+reported);
            Iterator iter = reported.iterator();
            while (iter.hasNext()) {
                String reportedUser = (String) iter.next();
                reportedNumberMap.put(reportedUser, reportedNumberMap.get(reportedUser) + 1);
            }
        }
        //System.out.println(reportedNumberMap);
    }

    static void setAnswer(String[] id_list, int k) {
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            if (reportedNumberMap.get(id) < k) continue;
            setAnswerMail(id, i);
        }
    }

    static void setAnswerMail(String id, int index) {
        //System.out.println("id: "+id+", index: "+index);
        Set<String> keySet = reportMap.keySet();
        for (String key : keySet) {
            HashSet<String> reportedSet = reportMap.get(key);
            int keyIndex = idIndexMap.get(key);
            // System.out.println(reportedSet);
            if (reportedSet.contains(id)) {
                answer[keyIndex]++;
            }
        }
    }

}

