import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            inputStack.push(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        
        boolean isPossible = true;
        int num = 1;
        
        for (int i = 0; i < n; i++) {
            int inputValue = inputStack.get(i);

            while (num <= inputValue) {
                resultStack.push(num);
                sb.append("+\n");
                num++;
            }

            if (!resultStack.isEmpty() && resultStack.peek() == inputValue) {
                resultStack.pop();
                sb.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }

        if(isPossible) System.out.println(sb);
        else System.out.println("NO");
    }
}

