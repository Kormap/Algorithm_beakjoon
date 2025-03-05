import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<int[]>> graph;
    static int[] dist;
    static int[] path;
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());    // 도시 수
        m = Integer.parseInt(br.readLine());    // 버스 수

        graph = new ArrayList<>();
        dist = new int[n+1];
        path = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[] {b, cost});
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        dijkstra(start, end);
    }

    public static void dijkstra(int start, int end) {
        // 노드 탐색
        for (int i = 1; i <= n; i++) {
            int node = 0;
            int minDistance = Integer.MAX_VALUE;

            for (int j = 1; j <= n; j++) {
                // 미방문, 최단거리 노드 탐색
                if(!visited[j] && dist[j] < minDistance) {
                    minDistance = dist[j];
                    node = j;
                }
            }

            if(node == 0) break;
            visited[node] = true;

            for (int[] cur : graph.get(node)) {
                int k = cur[0];    // 도착(경유)노드
                int cost = cur[1]; // 비용
                if(!visited[k] && dist[node] + cost < dist[k]) {
                    dist[k] = dist[node] + cost;  // 최소비용
                    path[k] = node;
                }
            }
        }
        System.out.println(dist[end]);
        
        ArrayList<Integer> route = new ArrayList<>();
        
        int cur = end;
        while (cur != 0) {      // 시작 도시 정점까지 반복
            route.add(cur);
            cur = path[cur];    // 이전 도시로 이동하며 경로 추가
        }

        Collections.reverse(route);
        System.out.println(route.size());
        
        for (int city : route) {
            System.out.print(city + " ");
        }
    }
}