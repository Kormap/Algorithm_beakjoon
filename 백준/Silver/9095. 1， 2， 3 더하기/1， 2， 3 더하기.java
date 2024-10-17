import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int T = sc.nextInt();   // 테스트케이스

        for(int i=0; i<T; i++){
            int n = sc.nextInt();   // 정수
            int[] dp = new int[12];

            // 정수 n을 1,2,3 의 합으로 나타내야함
            /*  n : 합으로 나타내는 방법의 수
                n=1 : 1가지(1)
                n=2 : 2가지(1+1, 2)
                n=3 : 4가지(1+1+1, 1+2, 2+1, 3)
                n=4 : 7가지(1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 1+3, 3+1)
                n=5 : 13가지(1+1+1+1+1,
                       1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1
                       1+1+3, 1+3+1, 3+1+1
                       2+2+1, 2+1+2, 1+2+2
                       2+3, 3+2)

                점화식 도출 : dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
             */

            // n=1,2, 3 일때 초기값 설정
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int j=4; j<=n; j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[n]);
        }

    }
}