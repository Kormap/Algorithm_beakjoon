import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] waitArr = new int[N];

        for (int i = 0; i < N; i++) {
            waitArr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        
        // 인출하는데 걸리는 시간이 짧은 순으로 정렬
        Arrays.sort(waitArr);
        for (int i = 0; i < N; i++) {
            answer += waitArr[i];
            for (int j = 0; j < i; j++) {
                answer += waitArr[j];
            }
        }
        System.out.print(answer);
    }
}