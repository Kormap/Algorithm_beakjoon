import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        Stack<int[]> stack = new Stack<>(); // [탑의 인덱스, 높이] 저장
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                int[] top = stack.peek();
                int topIndex = top[0];
                int topHeight = top[1];

                if (topHeight < height) {
                    stack.pop(); // 현재 탑보다 낮으면 제거
                } else {
                    break; // 현재 탑보다 높은 경우
                }
            }

            // 스택이 비어 있으면 0 출력
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                int[] top = stack.peek();
                int topIndex = top[0];
                sb.append(topIndex).append(" ");
            }

            // 현재 탑을 스택에 추가 (인덱스,높이 저장)
            stack.push(new int[]{i, height});
        }

        System.out.println(sb.toString().trim());
    }
}
