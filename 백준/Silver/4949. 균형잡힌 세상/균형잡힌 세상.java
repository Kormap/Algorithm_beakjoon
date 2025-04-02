import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if(".".equals(s)) break;
            
            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // 소괄호, 대괄호 시작일 경우
                if(c == '(' || c == '[') {
                    stack.push(c);
                }
                // 닫는 소괄호가 입력된 경우
                else if (c == ')'){
                    if(stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                // 닫는 대괄호가 입력된 경우
                else if (c == ']'){
                    if(stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }


            if(flag && stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
