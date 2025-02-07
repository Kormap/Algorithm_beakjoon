import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());   //수빈 위치
        int K = Integer.parseInt(st.nextToken());   //동생 위치
        visited = new boolean[100_001];

        int answer = bfs(N, K);
        System.out.println(answer);
    }

    public static int bfs(int x, int tx) {
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, 0});  //현위치, seconds
        visited[x] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int seconds = cur[1];
            
            int[] dx = {2, -1, 1};

            if(curX == tx) {
                return seconds;
            }

            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if(i == 0) nx = curX * dx[i];
                else nx = curX + dx[i];

                if(nx >= 0 && nx <= 100_000 && !visited[nx]) {
                    // 2 * X 의 위치로 순간이동하는 경우 0초 소요
                    if(i == 0) {
                        q.offer(new int[] {nx, seconds});
                        visited[nx] = true;
                    } else {    // x-1, x+1 의 경우 1초 소요
                        q.offer(new int[] {nx, seconds + 1});
                        visited[nx] = true;
                    }
                }
            }
        }
        return -1;
    }
}