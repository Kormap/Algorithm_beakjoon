import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int mArr[];
    static boolean visited[];

    // static int[] dx = {-1, 1, 0, 0};
    // static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mArr = new int[M];
        visited = new boolean[N];

        backTracking(N, M, 0);
    }

    public static void backTracking(int x, int y, int node) {
        if (node == M) {
            for (int value : mArr) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        // mArr 배열에 자연수를 오름차순으로 삽입
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                mArr[node] = i + 1;             // node = 0 일때 배열의 첫번째 값은 1
                backTracking(x, y, node + 1);   // 자식 노드방문(재귀호출)
                visited[i] = false;             // 재귀호출이 끝난 후 부모노드를 초기화
            }
        }
    }
}