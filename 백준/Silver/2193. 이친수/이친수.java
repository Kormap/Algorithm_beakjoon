import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];

        // dp 배열 초기설정
        dp[0] = 0;
        dp[1] = 1;     // CASE : 1
        // dp[2] = 1;  // CASE : 10
        // dp[3] = 2;  // CASE : 100, 101
        // dp[4] = 3;  // CASE : 1000, 1001, 1010

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}