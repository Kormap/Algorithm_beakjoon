import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

public class Main {
    static final int MAX_VALUE = Integer.MAX_VALUE;
    static List<List<int[]>> graph; // 인접 리스트
    static int[] dist;             //최단거리
    static boolean[] visited;
    static int V;
    static int E;
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());    // 정점(노드) 수
        E = Integer.parseInt(st.nextToken());    // 간선 수
        K = Integer.parseInt(br.readLine());     // 시작 노드

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>()); // 각 노드에 대한 리스트 초기화
        }
        
        dist = new int[V+1];
        visited = new boolean[V+1];

        Arrays.fill(dist, MAX_VALUE);
        dist[K] = 0;    // 시작노드 거리 초기화

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());   // 시작노드
            int b = Integer.parseInt(st.nextToken());   // 도착노드
            int w = Integer.parseInt(st.nextToken());   // 가중치
            graph.get(a).add(new int[]{b, w});  // 시작노드 -> 도착노드
        }

        dijkstra();

        for(int i = 1; i <= V; i++) {
            System.out.print(dist[i] == MAX_VALUE ? "INF\n" : dist[i]+ "\n");
        }
    }

    public static void dijkstra() {
        // 노드 수만큼 탐색
        for (int i = 1; i <= V; i++) {
            int node = 0;
            int minDistance = MAX_VALUE;

            for (int j = 1; j <= V; j++) {
                // 방문하지 않은 노드 중 최단거리인 노드 탐색
                if(!visited[j] && dist[j] < minDistance) {
                    minDistance = dist[j];
                    node = j;
                }
            }
            
            if(node == 0) break;
            visited[node] = true;

            // 선택된 노드의 거리 갱신, 기존 최단거리 값보다 최소거리인 경우 갱신됨
            for (int[] curr : graph.get(node)) {
                int k = curr[0];        // 도착노드
                int weight = curr[1];   // 가중치

                if(!visited[k] && dist[node] + weight < dist[k]) {
                    dist[k] = dist[node] + weight;
                }
            }
        }
    }
}