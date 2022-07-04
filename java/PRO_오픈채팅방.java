package bundang.algo.study.week04;


import java.util.*;

class PRO_오픈채팅방 {
    static class Node {
        String id;
        String nickName;
        boolean enter;

        public Node(String id, String nickName, boolean enter) {
            this.id = id;
            this.nickName = nickName;
            this.enter = enter;
        }
    }

    static List<Node> chat = new ArrayList<>();
    static Map<String, Node> user = new HashMap<>();

    public String[] solution(String[] record) {
        for (String line : record) {
            String[] info = line.split(" ");
            if (!info[0].equals("Change")) {
                setChatList(info[0], info[1]);
            }
            if (!info[0].equals("Leave")) {
                setUserMap(info[1], info[2]);
            }
        }
        String[] answer = new String[chat.size()];
        for (int i = 0; i < chat.size(); i++) {
            Node nowChat = chat.get(i);
            Node nowUser = user.get(nowChat.id);
            String nickName = nowUser.nickName;
            if (nowChat.enter) {
                answer[i] = nickName + "님이 들어왔습니다.";
            } else {
                answer[i] = nickName + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    static void setChatList(String status, String id) {
        boolean enter = true;
        if (status.equals("Leave")) {
            enter = false;
        }
        chat.add(new Node(id, "", enter));
    }

    static void setUserMap(String id, String nickName) {
        user.put(id, new Node(id, nickName, false));
    }
}

