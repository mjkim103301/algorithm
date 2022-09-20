package programmers.lv1;

public class PRO_신규아이디추천 {

    static String answer = "";

    public String solution(String new_id) {
        answer = new_id;
        makeLowerCase();

        deleteProhibitionChar();

        makeDotPossible();

        if (answer.isEmpty()) {
            answer += "a";
        }

        if (answer.length() >= 16) {
            deleteLastChar();
            makeDotPossible();
        }

        if (answer.length() <= 2) {
            addLastChar();
        }

        return answer;
    }

    static void makeLowerCase() {
        answer = answer.toLowerCase();
    }

    static void deleteProhibitionChar() {
        answer = answer.replaceAll("[^a-z-_.0-9]", "");
    }

    static void makeDotPossible() {
        if (answer.isEmpty()) {
            return;
        }
        answer = answer.replaceAll("[.]+", ".");
        if (answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        int length = answer.length();
        if (length == 0) {
            return;
        }
        if (answer.charAt(length - 1) == '.') {
            answer = answer.substring(0, length - 1);
        }
    }

    static void deleteLastChar() {
        answer = answer.substring(0, 15);

    }

    static void addLastChar() {
        if (answer.isEmpty() || answer.length() == 0) {
            return;
        }
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

    }

}
