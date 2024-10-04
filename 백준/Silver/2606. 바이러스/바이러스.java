import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();   //컴퓨터의 개수
    static int connect = sc.nextInt(); // 연결된 컴퓨터 쌍의 수
    static int[][] linkComp = new int[N+1][N+1];
    static boolean[] visited = new boolean[N+1];
    static int answer = 0;

    public static void main(String args[]) throws Exception {

        for(int i=0; i<connect; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            linkComp[x][y] = linkComp[y][x] = 1;
        }

        //  1번 컴퓨터 부터 바이러스 검사
        bfs(1);
        System.out.println(answer);
    }

    public static void bfs(int start){
        visited[start] = true;

        // 연결된 컴퓨터 개수만큼 탐색
        for(int i=0; i<=N; i++){
            if(linkComp[start][i] == 1 && !visited[i]){
                answer++;
                bfs(i);
            }
        }
    }
}
