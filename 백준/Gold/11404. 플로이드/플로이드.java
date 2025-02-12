import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // 도시 수
        int m = Integer.parseInt(br.readLine());    // 버스 수
        matrix = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(matrix[i], MAX_VALUE);
            matrix[i][i] = 0;  // 시작도시와 도착도시가 같은 경우는 없음
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken()); // 시작도시
            int b = Integer.parseInt(st.nextToken()); // 도착도시
            int c = Integer.parseInt(st.nextToken()); // 비용
            matrix[a][b] = Math.min(matrix[a][b], c);                // 최소비용 저장
        }

        // k: 경유노드, i: 시작노드, j: 도착노드
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 비용이 저장된 경로만 탐색
                    if(matrix[i][k] != MAX_VALUE && matrix[k][j] != MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] == MAX_VALUE ? 0 + " " : matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}