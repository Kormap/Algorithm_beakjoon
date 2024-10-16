import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int count = 0;
    static int answer = 0;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        // 연산1. if X%3 == 0 -> X/3
        // 연산2. if X%2 == 0 -> X/2
        // 연산3. 결과값 X 에 -1
        // 3가지 연산으로 숫자 1을 만들때, 연산을 사용하는 횟수가 최소값인 경우를 출력

        // 풀이 : DP 사용하여 Top-Down 방식으로 풀이
        int X = sc.nextInt();
        dp = new int[X + 1];
        dp[0] = dp[1] = 0;

        calculation(X);
        System.out.println(dp[X]);
    }

    public static void calculation(int x) {
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                // 2로 나누는 경우와 1을 더하는 경우 중 최소값
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                // 3으로 나누는 경우와 1을 더하는 경우 중 최소값
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
    }
}