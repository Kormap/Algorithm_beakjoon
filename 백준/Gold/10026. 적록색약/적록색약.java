import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char map[][];
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        // 적록색약 구분자(일반인)
        visited = new boolean[N][N];
        int normalCount = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    normalDfs(i, j);
                    normalCount++;
                }
            }
        }

        /*
         * 적록색약인 경우 빨강/초록이 붙어있을때, 한 구역으로 인식
        */
        visited = new boolean[N][N];
        int abnormalCount = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    abnormalDfs(i, j);
                    abnormalCount++;
                }
            }
        }
        System.out.println(normalCount + " " + abnormalCount);
    }
    
    // 정상인 RGB구역 탐색
    public static void normalDfs(int x, int y){
        visited[x][y] = true;

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == map[x][y]){
                normalDfs(nx, ny);
            }
        }
    }

    // 적록색약 RGB구역 탐색
    public static void abnormalDfs(int x, int y){
        visited[x][y] = true;

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                // 탐색 전/후 색상이 R,G 일 경우
                if ((map[x][y] == 'R' || map[x][y] == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                    abnormalDfs(nx, ny);
                } else if (map[nx][ny] == map[x][y]) {
                    abnormalDfs(nx, ny);
                }
            }
        }
    }
}