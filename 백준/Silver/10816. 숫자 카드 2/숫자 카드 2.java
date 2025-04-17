import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards); // 카드 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 정렬된 카드 기준 타겟의 마지막 인덱스 - 첫 인덱스 = 타겟 숫자(카드)의 개수
            sb.append(upBound(cards, target) - lowBound(cards, target)).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int lowBound(int[] cards, int target) {
        int left = 0;
        int right = cards.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int upBound(int[] cards, int target) {
        int left = 0;
        int right = cards.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
