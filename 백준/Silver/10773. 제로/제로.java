import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
       int K = sc.nextInt();
       Stack<Integer> stack = new Stack();

       for(int i = 0; i < K; i++) {
            int money = sc.nextInt();
            if(money == 0) {
                stack.pop();
            } else {
                stack.push(money);
            }
       }
       
       int sum = 0;
       while(!stack.isEmpty()){
            sum += stack.pop();
       }
       System.out.println(sum);
    }
}