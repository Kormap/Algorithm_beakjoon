import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();   //카드 갯수
        int P[] = new int[N + 1];    // index 개수 별 비용
        int dp[] = new int[N + 1];   // 최대금액

        for (int i = 1; i <= N; i++) {
            P[i] = sc.nextInt();    // i 개 카드의 금액 입력
        }

        // n 개 카드의 비용은 P[n] 값, 혹은 그 이하의 카드들을 더해서 "조합" 해야됨
        // 풀이 : N 개가 되는 P 값을 더하고, 그 중 최댓값을 출력
        // Step1. N 개가 되는 조합을 구하기
        // Step2. 조합하여 P 값을 저장
        // Step3. 저장해나가며 큰값을 선택

        // Step1. N 개가 되는 Pn 조합을 구하기
        /*
            dp[1] = P[1]
            dp[2] = dp[1] + P[1] or dp[0] + P[2]
            dp[3] = dp[2] + P[1] or dp[0] + P[3] or dp[1] + P[2]
            dp[4] = dp[3] + P[1] or dp[2] + P[2]
                    dp[1] + P[3] or dp[0] + P[4]

            점화식 도출 : dp[n] = dp[n-i] + P[i]
         */

        //초기값 세팅
        dp[1] = P[1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                // i=2 일때 기준으로,
                // j=1 일때 : dp[1] + P[1] 가 들어감
                // j=2 일때 : dp[0] + P[2] 가 들어감
                // j=1, j=2 중 큰 값을 저장(최대금액 저장을 위해)
                dp[i] = Math.max(dp[i - j] + P[j], dp[i]);
            }
        }
        System.out.println(dp[N]);

    }
}