package programmers.level1;

public class PRO_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long value = count * (count + 1) / 2;
        value *= price;
        return Math.max(value - money, 0);
    }
}
