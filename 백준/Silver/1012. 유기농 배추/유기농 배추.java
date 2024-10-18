import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int map[][];
    static boolean visited[][];
    static int M;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        int T = sc.nextInt();   //테스트케이스

        for (int i = 1; i <= T; i++) {
            N = sc.nextInt();   //세로
            M = sc.nextInt();   //가로
            int K = sc.nextInt();   //배추가 심어져 있는 위치 개수

            map = new int[M][N];
            visited = new boolean[M][N];

            //정답 초기화
            answer = 0;

            for (int j = 1; j <= K; j++) {
                int Y = sc.nextInt();   //Y좌표
                int X = sc.nextInt();   //X좌표

                map[X][Y] = 1;
            }

            for(int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {
                    if (map[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;

        //상하좌우 탐색을 위한 x,y 좌표
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        //상하좌우 네가지 케이스 탐색
        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY =  y + dy[i];
            // 좌표 내부만 탐색
            if (nowX >= 0 && nowX < M && nowY >= 0 && nowY < N) {
                if (map[nowX][nowY] == 1 && !visited[nowX][nowY]) {
                    visited[nowX][nowY] = true;
                    bfs(nowX, nowY);
                }
            }
        }

    }


}