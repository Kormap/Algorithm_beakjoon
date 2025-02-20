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
        
        int costValue = 0;      // 갱신되는 현재 금액
        int count = 0;

        while (costValue <= K) {
            if(costValue == K) break;
            int tempCostValue = 0;

            for (int i = 0; i < N; i++) {
                // 남은 금액과 같거나 작은 동전 중 제일 큰 값을 선택
                if(costs[i] <= K - costValue) {
                    tempCostValue = Math.max(costs[i], tempCostValue);
                }
            }
            costValue += tempCostValue;
            count++;
        }
        
        System.out.println(count);
    }
}