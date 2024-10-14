import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[][] dp;
    static int count1 = 0;
    static int count2 = 0;

    public static void main(String[] args) throws Exception {
        int T = sc.nextInt();   //테스트케이스 개수

        for (int i = 0; i < T; i++) {
            int m = sc.nextInt();   // 동쪽
            int n = sc.nextInt();   // 서쪽
            dp = new int[n+1][m+1];

            System.out.println(solve(n, m));
        }
    }

    private static int solve(int n, int m) {
        if (dp[n][m] > 0) return dp[n][m];

        if (n == m || m == 0) return dp[n][m] = 1;

        return dp[n][m] = solve(n - 1, m) + solve(n - 1, m - 1);
    }
}