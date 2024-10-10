import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int T = sc.nextInt();   //케이스
    static int M;//가로
    static int N;//세로
    static int K;//배추 갯수
    static int map[][];
    static boolean visited[][];
    static int count;

    public static void main(String args[]) throws Exception {

        for(int i = 0; i < T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][M];
            visited = new boolean[N][M];
            count = 0; //카운트 초기화

            for(int j = 0; j < K; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    //배추 존재유무, 체크 존재유무 확인 후 탐색
                    if(map[j][k] == 1 && !visited[j][k]){
                        bfs(j,k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});   //x,y 좌표
        visited[x][y] = true;

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while (!q.isEmpty()){
            int[] cur = q.poll();

            //상하좌우 4CASE
            for(int i = 0; i < 4; i++){
                int xPoint = cur[0];//x좌표
                int yPoint = cur[1];//y좌표
                xPoint += dx[i];
                yPoint += dy[i];

                //지도에 벗어나지 않은 경우만 체크
                if(xPoint >= 0 && xPoint < N && yPoint >= 0 && yPoint < M){
                    if(map[xPoint][yPoint] == 1 && !visited[xPoint][yPoint]){
                        q.offer(new int[]{xPoint, yPoint});
                        visited[xPoint][yPoint] = true;
                    }
                }
            }
        }
    }
}