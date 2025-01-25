import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int zeroCount;
    static int oneCount;
    static int[][] fiboResult;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        fiboResult = new int[41][2];    // n <= 40 , 0 호출횟수, 1 호출횟수 저장공간
        fiboResult[0][0] = 1;           // n=0 일때, 0 1회 호출
        fiboResult[0][1] = 0;           // n=0 일때, 1 0회 호출
        fiboResult[1][0] = 0;
        fiboResult[1][1] = 1;

       for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            int zeroCount = fiboResult[N][0];
            int oneCount = fiboResult[N][1];
            if(sb.length() == 0) {
                sb.append(zeroCount).append(" ").append(oneCount);
            } else {
                sb.append("\n").append(zeroCount).append(" ").append(oneCount);
            }
            zeroCount = 0;
            oneCount = 0;
       }
       System.out.println(sb);
    }

    public static void fibonacci(int n) {
        if(fiboResult[n][0] != 0 || fiboResult[n][1] != 0) return;
        
        // 피보나치수열 점화식 : fibonacci(n) = fibonacci(n‐1) + fibonacci(n‐2);
        fibonacci(n-1);
        fibonacci(n-2);
        
        fiboResult[n][0] = fiboResult[n-1][0] + fiboResult[n-2][0];
        fiboResult[n][1] = fiboResult[n-1][1] + fiboResult[n-2][1];
    }
}