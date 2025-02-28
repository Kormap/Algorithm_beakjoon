import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int inDegree[]; // 진입차수
    static ArrayList<ArrayList<Integer>> graph;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 키를 비교한 횟수
        inDegree = new int[N + 1];
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            // B의 진입차수 +1
            inDegree[B] += 1;
        }
        bfs();
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");

            // 진입차수 갱신, 큐 쌓기
            for (int val : graph.get(num)) {
                inDegree[val] -= 1; // 진입차수(간선) 제거
                if (inDegree[val] == 0) {
                    q.offer(val);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
