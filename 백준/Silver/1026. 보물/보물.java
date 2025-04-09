import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        
        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(inputA[i]);
            B[i] = Integer.parseInt(inputB[i]);
        }
        
        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B, Collections.reverseOrder()); // 내림차순 정렬
        
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }
        
        System.out.println(S);
    }
}
