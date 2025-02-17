import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
      
        for(int i=3; i>0; i--) {
            String input = br.readLine();
            if(input.equals("Fizz")||input.equals("Buzz")||input.equals("FizzBuzz")) {
                continue;
            }
            num = Integer.parseInt(input)+i;
            break;
        }
        
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }

    }
}