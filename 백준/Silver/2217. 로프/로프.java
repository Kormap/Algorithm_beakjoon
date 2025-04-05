import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());    // 로프 수

        int[] ropes = new int[N];
        int maxWeight = 0; // 로프들을 이용하여 들 수 있는 최대 중량
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes); // 오름차순정렬
        
        int ropeCnt = 0;
        for (int rope : ropes) {
            int weight = rope * (N - ropeCnt);
            if (maxWeight < weight) maxWeight = weight;
            ropeCnt++;
        }

        System.out.println(maxWeight);
    }
}
