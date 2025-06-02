import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                stack.push(input);
            } else {
                stack.pop();
            }
        }

        int totalPrice = 0;
        for (int price : stack) {
            totalPrice += price;
        }
        System.out.println(totalPrice);
    }
}
