import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] map;       // 창고
    static int M;
    static int N;
    static int H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());   //3차원 층

        map = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();
        
        int total = 0;     // 토마토전체 개수
        int count = 0;     // 익은토마토 개수

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[k][i][j] = Integer.parseInt(st2.nextToken());
                    // 익은 토마토 기준 6방향 탐색(상,하,좌,우,z축 위,아래)
                    if (map[k][i][j] == 1) {
                        q.offer(new int[]{k, i, j, 0});
                        count++;
                    }
                    if (map[k][i][j] != -1) {
                        total++;
                    }
                }
            }
        }

        int day = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];
            day = cur[3];

            int[] dx = {0, 0, -1, 1, 0, 0};
            int[] dy = {1, -1, 0, 0, 0, 0};
            int[] dz = {0, 0, 0, 0, 1, -1}; // z축

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if(map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = 1;
                        q.offer(new int[] {nz, nx, ny, day + 1});
                        count++;
                    }
                }
            }
        }
        
        // 토마토 전체가 익지 않으면 -1 반환
        if (total != count) {
            day = -1;
        }

        System.out.println(day);
    }
}