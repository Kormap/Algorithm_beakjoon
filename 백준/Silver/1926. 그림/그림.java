import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;   // 세로
    static int M;   // 가로
    static int[][] map;
    static boolean[][] visited;
    static int pictureCount = 0;
    static int pictureSize = 0;
    static int tempPictureSize = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
       map = new int[N][M];
       visited = new boolean[N][M];

       for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
       }

       for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    tempPictureSize = 1;    // 그림 size 초기화
                    dfs(i, j);
                    pictureCount++;
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(pictureSize);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 상하좌우 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
                tempPictureSize++;
            }
        }

        pictureSize = Math.max(tempPictureSize, pictureSize);
    }
}