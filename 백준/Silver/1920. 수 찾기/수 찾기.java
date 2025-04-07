import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A 오름차순 정렬
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < M; j++) {
            int num = Integer.parseInt(st.nextToken());
            if(binarySearch(A, num)) {
                sb.append("1\n");
            } else sb.append("0\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean binarySearch(int[] A, int num) {
        // 배열 크기를 기준으로 이진탐색
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(A[mid] == num) return true;
            else if(A[mid] < num) left = mid + 1;   // 배열의 중간에 위치한 값보다 큰 경우
            else right = mid - 1;                   // 배열의 중간에 위치한 값보다 작은 경우
        }
        return false;
    }
}
