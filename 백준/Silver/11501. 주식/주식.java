import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] prices = new int[N];
            
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());   // 주가
            }
            
            long maxProfit = 0; // 최대 이익
            int maxPrice = prices[N - 1]; // 최대값
            
            for (int i = N - 2; i >= 0; i--) {
                if (prices[i] > maxPrice) {
                    // 현재 주가가 최대값보다 큰 경우
                    maxPrice = prices[i];
                } else {
                    // 현재 주가가 최대값보다 작은 경우
                    maxProfit += maxPrice - prices[i];
                }
            }
            
            sb.append(maxProfit).append("\n");
        }
        
        System.out.print(sb);
    }
}
