import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int[][] result;
    static boolean[] visitedNode;

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        result = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 노드(정점)를 시작점으로 BFS 탐색
        for (int i = 0; i < n; i++) {
            visitedNode = new boolean[n];
            bfs(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void bfs(int startNode) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);             //시작 노드
    
        while (!q.isEmpty()) {
            int currNode = q.poll();    //탐색중인 노드

            for(int j = 0; j < n; j++) {
                if(!visitedNode[j] && matrix[currNode][j] == 1) {
                    q.offer(j);
                    visitedNode[j] = true;
                    result[startNode][j] = 1;
                }
            }
        }
    }
}