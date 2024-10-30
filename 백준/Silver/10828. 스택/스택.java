import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();

        int N = sc.nextInt(); //명령의 수
        sc.nextLine();        //for 문 이전 개행문자 제거용

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < N; i++) {
            String order = sc.nextLine();   //명령
            if(order.contains("push")) {
                int num = Integer.parseInt(order.replace("push","").trim());
                stack.push(num);
            }else if(order.contains("pop")) {
                if(stack.isEmpty()){
                    sb.append(-1).append('\n');
                }else {
                    int num = stack.pop();
                    sb.append(num).append('\n');
                }
            }else if(order.contains("size")) {
                int size = stack.size();
                sb.append(size).append('\n');
            }else if(order.contains("empty")) {
                if(stack.isEmpty()){
                    sb.append(1).append('\n');
                }else {
                    sb.append(0).append('\n');
                }
            }else if(order.contains("top")) {
                if(stack.isEmpty()){
                    sb.append(-1).append('\n');
                }else {
                    int num = stack.peek();
                    sb.append(num).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}