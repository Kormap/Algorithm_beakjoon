import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean[] visited;
    static int n = 0;
    static int[][] connectArr;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        n = sc.nextInt();       //컴퓨터의 수
        int connect = sc.nextInt(); //연결된 컴퓨터 쌍

        connectArr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= connect; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            connectArr[x][y] = connectArr[y][x] = 1;
        }

        bfs(1);
        System.out.println(answer);
    }

    public static void bfs(int x) {
        visited[x] = true;
        
        for(int i=1; i<=n; i++){
            if(connectArr[x][i] == 1 && !visited[i]){
                visited[i] = true;
                answer++;
                bfs(i);
            }
        }
    }

}