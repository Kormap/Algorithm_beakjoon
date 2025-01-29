import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Stack<Integer> inputStack = new Stack<>();
    static Stack<Integer> resultStack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < n; i++) {
                inputStack.push(Integer.parseInt(br.readLine()));
            }

            boolean result = isPossible(n, inputStack);

            if (result) System.out.println(sb.toString());
            else System.out.println("NO");
    }

    public static boolean isPossible(int n, Stack<Integer> inputStack) {
        // 입력 Stack 처럼 정렬이 가능한지 여부 판단
        boolean isPossible = true;
        int num = 1;    // 오름차순으로 정렬된 수열 1~n
        
        for (int i = 0; i < n; i++) {
            int inputValue = inputStack.get(i);

            while (num <= inputValue) {
                resultStack.push(num);
                sb.append("+\n");
                num++;
            }

            if(!resultStack.isEmpty() && resultStack.peek() == inputValue) {
                resultStack.pop();
                sb.append("-\n");
            } else {
                isPossible = false;
                break;
            }
        }
        return isPossible;
    }
}

/* [] : pop 연산된 숫자의 수열 = inputStack -> true
 * 1. push
 * 1
 * 
 * 2. push
 * 1, 2
 * 
 * 3. push
 * 1, 2, 3
 * 
 * 4. push
 * 1, 2, 3, 4
 * 
 * 5. pop [4]
 * 
 * 1, 2, 3
 * 6. pop [4,3]
 * 
 * 1, 2
 * 7. push [4,3]
 * 
 * 1, 2, 5
 * 8. push [4,3]
 * 
 * 1, 2, 5, 6
 * 9. pop [4, 3, 6]
 * ...
 * ..
 */