import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;

    static int node[][];        //간선
    static boolean visited[];   //정점
    static int count = 0;

    public static void main(String args[]) throws Exception {
        N = sc.nextInt();   //정점 개수
        M = sc.nextInt();   //간선 개수
        node = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            node[x][y] = node[y][x] = 1;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i <= N; i++){
                if(node[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}