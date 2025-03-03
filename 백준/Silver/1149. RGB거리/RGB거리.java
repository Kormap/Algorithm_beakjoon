import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // R,G,B 배열
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {   // j값 1: R, 2: G, 3: B
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp 초기값 설정
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);   // RED인 경우 = 초록, 파랑 + 현재 RED 비용
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);   // GREEN인 경우 = 빨강 + 파랑 + 현재 GREEN인 비용
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);   // BLUE인 경우
        }

        int minCost = Math.min(dp[N-1][2], Math.min(dp[N-1][0], dp[N-1][1]));
        System.out.println(minCost);
    }
}