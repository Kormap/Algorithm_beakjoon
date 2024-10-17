import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();       //카드의 개수
        int[] P = new int[N + 1];   //카드팩 금액
        int[] dp = new int[N + 1];  //i 개 구매시 최소금액

        for (int i = 1; i <= N; i++) {
            P[i] = sc.nextInt();    // P[i] 의 금액
        }

        /*
            n=1 : P[1]
            n=2 : P[1]+P[1] or P[2]
            n=3 : P[1]+P[1]+P[1] or P[2]+P[1] or P[3]

            dp[1] : P[1] => dp[1] (최소 금액은 자연스럽게 P[1] 이됨)
            dp[2] : dp[1] + P[1] or dp[0] + P[2]
            dp[3] : dp[2] + P[1] or dp[0] + P[3]
            dp[4] : dp[3] + P[1] or dp[0] + P[4]

            점화식 도출
            dp[i] = dp[i-j] + P[j]
         */

        //dp 초기값 설정
        dp[1] = P[1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                // i=2 일때, 2중 for 문은
                // dp[2] = dp[1]+P[1] or dp[0]+P[2] 조합이 됨
                // -> 그중에 최소값을 dp[2] 에 저장
                
                //최소값을 찾기 위해 처음값은 저장
                if(j==1) dp[i] = dp[i-j] + P[j];
                dp[i] = Math.min(dp[i-j] + P[j], dp[i]);
            }
        }

        System.out.println(dp[N]);

    }
}