package programmers.level1;

public class PRO_나머지가_1이되는_수_찾기 {
    public int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return -1;
    }
}
