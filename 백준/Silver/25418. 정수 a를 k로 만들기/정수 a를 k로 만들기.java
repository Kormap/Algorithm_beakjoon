import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static int answer = 0;
    static int A = sc.nextInt();
    static int K = sc.nextInt();

    public static void main(String args[]) throws Exception {
        answer = bfs(A);
        System.out.println(answer);
    }

    public static int bfs(int A) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[K+1];
        q.offer(new int[]{A,0});    // 현재값 A, 연산횟수 0 초기

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int val = current[0];   // 현재 값
            int count = current[1]; // 연산 횟수

            if(val == K) return count;

            // 방문되지 않은 경우만 진행
            if(!visited[val]){
                visited[val] = true;

                // CASE1. +1 연산
                if(val + 1 <= K && !visited[val +1]){
                    q.offer(new int[]{val + 1, count + 1});
                }
                // CASE2. x2 연산
                if(val * 2 <= K && !visited[val * 2]){
                    q.offer(new int[]{val * 2, count + 1});
                }
            }
        }
        return 0;   // 값이 존재하지 않는 경우만 0 리턴
    }
}