import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int[] count = new int[3]; // -1, 0, 1의 개수를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
    }

    // 재귀함수
    static void divide(int row, int col, int size) {
        if (checkSame(row, col, size)) {
            int num = paper[row][col];
            count[num + 1]++; // -1은 index 0, 0은 index 1, 1은 index 2
            return;
        }

        int newSize = size / 3;

        // 종이 9등분으로 자르기
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }

    static boolean checkSame(int row, int col, int size) {
        int first = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != first) return false;
            }
        }
        return true;
    }
}
