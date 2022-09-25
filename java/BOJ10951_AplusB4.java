package baekjoon.level_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10951_AplusB4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input == null) {
                return;
            }
            String[] nums = input.split(" ");
            System.out.println(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
        }
    }
}
