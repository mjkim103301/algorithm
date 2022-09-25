package baekjoon.level_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10952_AplusB5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] nums = br.readLine().split(" ");
            if (nums[0].equals("0") && nums[1].equals("0")) {
                return;
            }
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            System.out.println(num1 + num2);
        }
    }
}
