import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] nums;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nums = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       
        dp[0][0] = nums[0][0];
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + nums[i][j];
                } else if(j == N-1) {
                    dp[i][j] += dp[i-1][j-1] + nums[i][j];
                } else {
                    dp[i][j] += Math.max(dp[i-1][j-1] + nums[i][j], dp[i-1][j] + nums[i][j]);
                }
            }
        }

        int temp = 0;
        int answer = 0;
        for(int i = 0; i < N; i++) {
            temp = dp[N-1][i];
            answer = Math.max(temp, answer);
        }
        System.out.println(answer);
    }
}