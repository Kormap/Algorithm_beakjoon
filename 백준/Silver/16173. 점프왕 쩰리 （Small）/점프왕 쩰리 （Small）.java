import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();   // 맵의 크기
    static int[][] map = new int[N][N];  // 맵 데이터
    static boolean[][] mapVisited = new boolean[N][N];
    static int[] dx = {0,1}, dy = {1,0};

    public static void main(String args[]) throws Exception {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // NxN 맵 데이터 생성
                map[i][j] = sc.nextInt();
            }
        }

        BFS(0,0);
        System.out.println("Hing");
    }

    public static void BFS(int i, int j){
        if(map[i][j] == -1){
            System.out.println("HaruHaru");
            System.exit(0);
        } else {
            // 아래, 오른쪽 방향 - 2가지 방향이동 가능
            for(int k=0; k<2; k++){
                int x = i + dx[k] * map[i][j];
                int y = j + dy[k] * map[i][j];

                // 게임판의 크기와 같거나 작을때만 이동가능
                if(x <= N-1 && y <= N-1 && !mapVisited[x][y]){
                    // x,y 좌표 탐색 기록
                    mapVisited[x][y] = true;

                    // 해당 좌표 다시 탐색
                    BFS(x,y);
                }

            }
        }

    }
}
