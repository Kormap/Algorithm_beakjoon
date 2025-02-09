import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        matrix = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        bfs(1, n);
        System.out.println(count);
    }

    public static void bfs(int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start, 0});  //시작노드, depth
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int depth = cur[1];

            if(depth > 2) continue;

            for (int i = start; i <= end; ++i) {
                if(!visited[i] && matrix[node][i] == 1) {
                    q.offer(new int[] {i, depth + 1});
                    visited[i] = true;
                    if(depth +1 <= 2) count++;
                }
            }
        }
        
    }
}