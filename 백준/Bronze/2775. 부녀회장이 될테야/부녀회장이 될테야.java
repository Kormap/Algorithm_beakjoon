import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[][] downFloor;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        int T = sc.nextInt();   //테스트케이스

        for (int i = 0; i < T; i++) {
            int k = sc.nextInt();   //층
            int n = sc.nextInt();   //호
            downFloor = new int[k + 1][n + 1];

            //0층의 j 호에는 j 명이 거주함
            for (int j = 1; j <= n; j++) {
                downFloor[0][j] = j;
            }
            answer = group(k, n);
            System.out.println(answer);
        }

    }

    public static int group(int k, int n) {
        if (k < 0 || n < 1) return 0;
        if (downFloor[k][n] != 0) return downFloor[k][n];

        // k-1 층의 1호~n호 까지 사람들의 수의 합 구하기
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                // k층의 n-1호 까지 인원 수 계속 더하여 저장
                downFloor[i][j] += downFloor[i -1][j] + downFloor[i][j - 1];
            }
        }
        return downFloor[k][n];
    }
}