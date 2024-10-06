import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //가로
        int M = sc.nextInt();   //세로
        int[][] map = new int[M][N];

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                //지도 데이터 입력
                map[i][j] = sc.nextInt();
            }
        }

        // 북서쪽끝 -> 남동쪽끝
        // 오른쪽(동쪽), 아래쪽(남쪽)으로만 이동가능
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<>();
        String answer = "No";

        //큐에 북서쪽끝(0,0) 부터 시작
        queue.offer(new int[]{0,0}); // x,y축 값

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 남동쪽끝에 도달한 경우 좌표상 (N,M)
            if(x == M-1 && y == N-1) {
                answer = "Yes";
                break;
            }

            // CASE1. 오른쪽으로 이동 시
            if(y+1 < N && map[x][y+1] == 1 && !visited[x][y+1]) {
                visited[x][y+1] = true;
                queue.offer(new int[]{x, y+1});
            }

            // CASE2. 아래쪽으로 이동 시
            if(x+1 < M && map[x+1][y] == 1 && !visited[x+1][y]) {
                visited[x+1][y] = true;
                queue.offer(new int[]{x+1, y});
            }
        }

        System.out.println(answer);

    }
}