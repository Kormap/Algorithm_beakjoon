import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int w;   //너비
    static int h;   //높이
    static int[][] map; //지도
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();
            map = new int[w][h];
            visited = new boolean[w][h];
            int count = 0;

            if(h == 0 && w == 0) break;

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            //지도 탐색 시작
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int xNow, int yNow) {
        visited[xNow][yNow] = true;
        // 섬은 현재 값에서 상하좌우 + 대각선이 탐색되는 것으로 카운트
        int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
        int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1};

        // 상하좌우 + 대각선 8방향 탐색
        for (int i = 0; i < 8; i++) {
            //현재값 + 이동탐색값 = 탐색할 좌표
            int x = xNow + dx[i];
            int y = yNow + dy[i];

            //지도 내부 좌표로 제한
            if(x >= 0 && x < w && y >= 0 && y < h){
                if (map[x][y] == 1 && !visited[x][y]) {
                    dfs(x, y);
                }
            }
        }

    }

}