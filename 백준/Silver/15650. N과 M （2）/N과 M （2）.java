import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] chooseNums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        chooseNums = new int[M];

        back(N, M, 1, 0);
    }

    public static void back(int N, int M, int start, int depth) {
        if(depth == M) {
            for (int val : chooseNums) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            chooseNums[depth] = i;
            back(N, M, i + 1, depth + 1);
        }
    }

}