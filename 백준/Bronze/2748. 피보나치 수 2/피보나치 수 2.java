import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static long[] dp;

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();   // n번째

        dp = new long[n + 1];
        dp[0] = 0;

        System.out.println(dp(n));
    }

    static long dp(int n) {
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];

        dp[n] = dp(n-1) + dp(n-2);
        return dp[n];
    }

}