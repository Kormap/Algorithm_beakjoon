import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (".".equals(s))
                break;

            Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                        break;
                    }
                }

            }

            if (stack.isEmpty() && flag)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }

}
