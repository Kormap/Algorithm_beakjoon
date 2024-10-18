import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();
        int dp[][] = new int[N + 1][10];    // i= 수의 길이, j=마지막자리(0~9), dp[][] => 오르막수의 개수
        int mod = 10007;

        /*
            오르막 수 : 자리가 오름차순을 이루는 수
            인접한 수가 같아도 오름차순으로 친다.(EX :2234, 3678, 11119)
            수는 0으로 시작할 수 있음

            n=1 : 10 (0,1,2,3,4,5,6,7,8,9)
                      1+1+...+1
            n=2 : 55 (00~09, 11~19,22~29,33~39,44~49,55~59,66~69,77~79,88~89,99)
                      10+9+8+7+ ... +1
            n=3 : 220 (000~099, 111~119, 122~129, ... , )
            n=4 : (0001~0009, 0011~0019, ...)

            dp[1][0] ~ dp[1][9] = 1
            dp[2][0] ~ dp[2][9]
            => dp[2][0]의 원소 : 00 -> 1
               dp[2][1]의 원소 : 01, 11 -> 2
               dp[2][2]의 원소 : 02, 12, 22 -> 3

            => dp[3][0]의 원소 : 000 -> 1
               dp[3][1]의 원소 : 001,011,111 -> 3 => dp[2][0] + dp[2][1] (1+2)

            길이가 n인 오르막의 개수는 길이가 n-1인 오르막의 수를 0부터 j 까지 더하면 된다.

            도출 점화식 : dp[i][j] = dp[i-1][0] + .. + dp[i-1][j]
         */

        // 초기값 설정
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
        }
        System.out.println(answer % mod);

    }
}