import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] costs;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() ," ");

        int N = Integer.parseInt(st.nextToken());   // 동전 수
        int K = Integer.parseInt(st.nextToken());   // 금액합계
        
        costs = new int[N];

        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(br.readLine());
        }
        
        int costValue = K;      // 갱신되는 현재 금액
        int count = 0;

        for (int i = N-1; i >= 0; i--) {
            if(costs[i] <= costValue) {
                count += costValue / costs[i];       // 선택한 동전의 필요 개수
                costValue = costValue % costs[i];    // 남은 금액 : 금액총합(K) - 선택된 동전 합계
            }
        }
        
        System.out.println(count);
    }
}