import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static int[][] area;
    static int N = 0;
    static boolean[][] visited;
    static int tempAnswer = 0;
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        N = sc.nextInt();       // N x N
        area = new int[N][N];   // 지도

        //지도 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                area[i][j] = sc.nextInt();
            }
        }

        //풀이순서
        //Step1. 높이 n(1~100) 이하인 모든 지점이 물에 잠김 처리
        for(int i = 1; i <= 100; i++){
            visited = new boolean[N][N];    // 높이가 변경될때 마다 방문처리배열 초기화
            tempAnswer = 0;

            for(int x = 0; x < N; x++){
                for(int y = 0; y < N; y++){
                    //Step2. 물에 잠기지 않은 영역(i 이상인 지역만)에 대해 BFS 탐색
                    if(area[x][y] > i && !visited[x][y]){
                        visited[x][y] = true;
                        tempAnswer++;
                        bfs(x,y,i);
                    }
                }
            }
            answer = Math.max(tempAnswer, answer);
        }

        System.out.println(answer);
    }

    public static void bfs(int x, int y, int i){
        
        //상하좌우 탐색
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        //4방향 탐색
        for(int j=0; j<4; j++){
            int nx = x + dx[j];
            int ny = y + dy[j];

            //지도 내만 탐색
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(area[nx][ny] > i && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    bfs(nx, ny, i);
                }
            }
        }

    }

}