import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F; 
    static int S;
    static int G;    
    static int U;
    static int D;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());   // 최대 층 수
        S = Integer.parseInt(st.nextToken());   // 현재 위치
        G = Integer.parseInt(st.nextToken());   // 스타트링크 위치

        U = Integer.parseInt(st.nextToken());   // Up
        D = Integer.parseInt(st.nextToken());   // Down

        visited = new boolean[F+1];

        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {S, 0});
        
        boolean isPossible = false;
        int count = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nowPos = cur[0];
            count = cur[1];

            if(nowPos == G) {
                isPossible = true;
                break;
            }
            
            int upPos = nowPos + U;
            int downPos = nowPos - D;

            if(upPos <= F && !visited[upPos]) {
                visited[upPos] = true;
                q.offer(new int[] {upPos, count + 1});
            }

            if(downPos > 0 && !visited[downPos]) {
                visited[downPos] = true;
                q.offer(new int[] {downPos, count + 1});
            }
        }

        if(isPossible) System.out.println(count);
        else System.out.println("use the stairs");
    }
}