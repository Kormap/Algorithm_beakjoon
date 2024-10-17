import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();
        int dp[][] = new int[N + 1][10];
        int mod = 1000000000;
        int answer = 0;

        // 길이가 N인 계단수 갯수 구하기 : 인접한 모든 자리의 차이가 1인 경우 계단수
        /*
            n=1 : 9 (1,2,3,4,5,6,7,8,9)
            n=2 : 17 (10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98)
            n=3 : (101,121,123,210,212,234,243...)

        점화식 도출
        1. dp[i][j] : i = 길이(자리수), j = 마지막숫자가 j 인 계단수의 개수
        2. j=0 일때, 그 앞자리는 무조건 1이어야함. -> dp[i][0] = dp[i-1][1]
           j=1~8일때 그 앞자리는 +1,-1 이어야함 -> dp[i][1~8] = dp[i-1][j-1] or dp[i-1][j+1]
           j=9 일때, 그 앞자리는 무조건 8이어야함 -> dp[i][9] = dp[i-1][8]
         */

        // 길이가 1인 계단수 초기설정
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j + 1] % mod;
                else if (j == 9) dp[i][j] = dp[i - 1][j - 1] % mod;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        // 길이가 N 인 계단수의 개수는 dp[N][j] 의 합이다.
        for (int j = 0; j <= 9; j++) {
            answer = (answer + dp[N][j]) % mod;
        }

        System.out.println(answer);

    }
}