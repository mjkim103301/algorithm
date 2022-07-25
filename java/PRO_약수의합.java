package programmers.level1;

class PRO_약수의합 {

    public int solution(int n) {
        int answer = 0;
        int middle = (int) Math.sqrt(n);
        for (int i = 1; i <= middle; i++) {
            if (n % i == 0) {
                answer += i;
                if (i != n / i) {
                    answer += n / i;
                }
            }
        }
        return answer;
    }
}