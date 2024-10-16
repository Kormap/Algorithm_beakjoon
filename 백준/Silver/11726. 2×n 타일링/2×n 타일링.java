import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();   // 2 x N 크기 직사각형
        int[] dp = new int[1001];

        // 점화식 구하기
        // n=1 : 1가지방법(2x1 타일 한개)
        // n=2 : 2가지방법(1x2 타일 두개, 2x1 타일 두개)
        // n=3 : 3가지방법(1x2 타일 세개, 1x2 타일 두개 + 2x1 타일 하나, 2x1 타일 두개 + 1x2 타일 하나)
        // n=4 : 5가지방법
        // 1. 1x2 타일 네개, 2. 2x1 타일 네개, 3. 1x2 타일 두개 + 2x1 타일 두개,
        // 4. 1x2 타일 하나 + 2x1 타일 두개 + 1x2 타일 하나, 5. 2X1 타일 두개 + 1x2 타일 두개,
        // 도출 점화식 :dp[n] = dp[n-1] + dp[n-2]

        // n=1, n=2 일때 초기값 설정
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }


}