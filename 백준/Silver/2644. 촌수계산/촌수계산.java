import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int n;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //전체 사람 수
        
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        int targetOne = Integer.parseInt(st.nextToken());
        int targetTwo = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());   //부모자식들간 관계 개수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   //부모
            int y = Integer.parseInt(st.nextToken());   //자식

            graph[x][y] = graph[y][x] = 1;
        }

        System.out.println(bfs(targetOne, targetTwo));
    }

    static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        int answer = 0; //촌수

        while (!q.isEmpty()) {
            /* 
             EX : start = 7 일때, Queue 에 2가 들어옴
             부모가 2인 경우의 자식들을 모두 count 하면안됨
             -> 큐에 offer 된 부모로 탐색할 숫자의 탐색이 모두 마쳐지면 촌수를 카운트
            */
            int size = q.size();
            for(int i = 0; i < size; i++){
                int x = q.poll();
                if(x == end) return answer;

                for(int j = 1; j <= n; j++) {
                    if(graph[x][j] == 1 && !visited[j]) {
                        q.offer(j);
                        visited[j] = true;
                    }
                }
            }
            answer++;
        }

        //친척관계가 아닌 경우 -1 출력
        if(!visited[end]) {  
            answer = -1;
        }
        return answer;
    }
}