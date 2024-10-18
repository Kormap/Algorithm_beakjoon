import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];


        // N 개의 줄에 M 개의 미로가 주어짐
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            int lineSize = line.length();
            for (int j = 0; j < lineSize; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        // 이동은 상하좌우 총 4방향으로 이동 가능
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            x = cur[0];
            y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //미로 내부지역만 탐색
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}