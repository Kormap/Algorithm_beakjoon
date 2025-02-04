import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] plate;    // N x N 체스판
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());    // N x N 체스판
            plate = new int[N][N]; 
            visited = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            int answer = bfs(nowX, nowY, targetX, targetY);
            System.out.println(answer);
        }
    }

    public static int bfs(int x, int y, int tx, int ty) {
        // 나이트의 경우 8방향 탐색
        int[] dx = {-2, -1, 1, 2,  2,  1, -1, -2};
        int[] dy = {1,   2, 2, 1, -1, -2, -2, -1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 0});
        visited[x][y] = true;
        
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int count = cur[2];

            if (curX == tx && curY == ty) return count;

            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    q.offer(new int[] {nx, ny, count + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}