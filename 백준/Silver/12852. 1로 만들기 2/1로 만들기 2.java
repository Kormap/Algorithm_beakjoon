import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];  // 연산 횟수
        int[] historyNum = new int[N + 1];  // 포함되어 있는 수
        
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            // 1을 빼는 경우
            if (dp[i - 1] + 1 < dp[i]) {
                dp[i] = dp[i - 1] + 1;
                historyNum[i] = i - 1;
            }
            // 3으로 나눠지는 경우
            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                historyNum[i] = i / 3;
            }
            // 2로 나눠지는 경우
            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                historyNum[i] = i / 2;
            }
        }

        // 최소 연산 횟수
        System.out.println(dp[N]);
        
        StringBuilder sb = new StringBuilder();

        while (N >= 1) {
            sb.append(N).append(" ");
            N = historyNum[N];  // 이전값 세팅
        }
        
        System.out.println(sb.toString().trim());
        
    }
}
