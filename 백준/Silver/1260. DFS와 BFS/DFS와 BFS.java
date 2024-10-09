import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;   //정점의 개수
    static int M;   //간선의 개수
    static int V;   //정점의 번호
    static int count;

    static int nodeVisited[][]; //노드기록 배열
    static boolean visited[]; //간선기록 배열

    public static void main(String args[]) throws Exception {
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        nodeVisited = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++) {
            //정점의 번호 2개
            int x = sc.nextInt();
            int y = sc.nextInt();
            nodeVisited[x][y] = nodeVisited[y][x] = 1;
        }

        //DFS
        DFS(V);

        // visited 초기화 후 사용
        visited = new boolean[N+1];
        System.out.println();
        
        //BFS
        BFS(V);

    }

    public static void DFS(int i){
        visited[i] = true;
        System.out.print(i+" ");

        if(count == N){
            return;
        }
        count++;

        //정점의 개수만큼 반복
        for(int j=1; j<=N; j++){
            if(nodeVisited[i][j] == 1 && !visited[j]){
                    DFS(j);
                }
        }
    }

    public static void BFS(int i){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i); //q 에 작업 추가
        visited[i] = true;
        System.out.print(i+" ");

        while (!q.isEmpty()){
            i = q.poll(); //확인 후 제거

            //정점의 개수만큼 반복
            for(int j=1; j<=N; j++){
                if(nodeVisited[i][j] == 1 && !visited[j]){
                    q.offer(j);
                    visited[j] = true;
                    System.out.print(j+" ");
                }
            }
        }

    }
}