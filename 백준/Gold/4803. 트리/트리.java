import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = 1;

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            graph = new ArrayList<>();
            visited = new boolean[n + 1];

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int treeCount = 0;
            for (int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    if(bfs(i)) {
                        treeCount++;
                    }
                }
            }
            sb.append("Case ").append(caseCount).append(": ");

            if(treeCount == 0) sb.append("No trees.");
            else if(treeCount == 1) sb.append("There is one tree.");
            else if(treeCount > 1) sb.append("A forest of ").append(treeCount).append(" trees.");
            sb.append("\n");
            
            caseCount++;
        }
        System.out.println(sb.toString()); 
    }

    public static Boolean bfs(int start) {
        boolean result = false;
        visited[start] = true;

        int node = 0;   // 정점 수
        int edge = 0;   // 간선 수

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll(); // 시작노드(정점)
            node++;

            // 시작 노드와 연결된 정점 탐색
            for (int target : graph.get(cur)) {
                if(!visited[target]){
                    visited[target] = true;
                    q.offer(target);
                }
                edge++;
            }
        }

        if(node == edge/2 + 1) result = true;
        return result;
    }
}