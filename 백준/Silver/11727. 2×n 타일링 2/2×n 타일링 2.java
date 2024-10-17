import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();   // 2 x N 크기 직사각형
        int[] dp = new int[1001];

        // 점화식 구하기
        /*  2xN 직사각형 방법의 수
            n=1 : 한가지(2x1 타일)
            n=2 : 세가지(1x2 타일 두개, 2x1 타일 두개, 2x2 타일하나)
            n=3 : 다섯가지(1x2 타일 세개, 2x1 타일 두개 + 1x2 타일 하나,
                   1x2 타일 하나 + 2x1 타일 두개, 2x2 타일 하나 + 1x2 타일 하나)
            n=4 : 열한가지(1. 1x2 타일 네개, 2. 1x2 타일 두개 + 2x1 타일 두개
                   3. 1x2 타일 투개 + 2x2 타일 하나, 4. 2x1 타일두개 + 1x2 타일 두개
                   5. 2x2 타일하나 + 1x2 타일두개, 6. 1x2 타일 하나 + 2x1타일두개 + 1x2 타일 하나
                   7. 2x1 타일두개 + 2x2 타일하나, 8. 2x2 타일 두개 ... )
        */

        // n =1, 2 일때 초기값 설정
        dp[1] = 1;
        dp[2] = 3;

        // 도출 점화식 : dp[n] = dp[n-1] + dp[n-2] * 2
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }
        System.out.println(dp[n]);
    }
}