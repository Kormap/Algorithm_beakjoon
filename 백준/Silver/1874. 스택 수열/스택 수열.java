import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder();

        int current = 1; // 오름차순 숫자 초기설정
        int idx = 0; // while문 인덱스
        boolean isPossible = true;

        while (idx < n) {
            int target = nums[idx];

            // 타겟숫자까지 적재
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            // 타겟숫자인 경우 pop
            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
                idx++;
            } else {
                isPossible = false;
                break;
            }
        }

        if (isPossible)
            System.out.println(sb.toString());
        else
            System.out.println("NO");
    }
}
