import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scoreArr = new int[N+1];
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            scoreArr[i] = Integer.parseInt(br.readLine());
        }
        /* 
            dp[n] = dp[n-2] + scoreArr[i] 
                 or dp[n-3] + scoreArr[i-1] + scoreArr[i]
        */ 

        dp[1] = scoreArr[1];
        if(N >= 2) dp[2] = dp[1] + scoreArr[2];
        if(N >= 3) dp[3] = Math.max(dp[1] + scoreArr[3], dp[2] + scoreArr[2] + scoreArr[3]);

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + scoreArr[i], dp[i-3] + scoreArr[i-1] + scoreArr[i] );
        }

        System.out.println(dp[N]);
    }
}