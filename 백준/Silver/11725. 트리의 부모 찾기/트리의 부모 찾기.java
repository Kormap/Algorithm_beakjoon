import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N;
//    static int tree[][];
    static int parent[];
    static boolean visited[];

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        N = sc.nextInt();           //노드 개수
//        tree = new int[N+1][N+1];   //트리
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        //트리
        visited = new boolean[N+1]; //정점
        parent = new int[N+1]; //정점



        for (int i = 0; i < N-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
//            tree[x][y] = tree[y][x] = 1;
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        bfs(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int x) {
        visited[x] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i : tree.get(cur)){
                if(!visited[i]){
                    visited[i] = true;
                    parent[i] = cur;    //cur : 부모, parent 번지(i) : 자식
                    q.offer(i);
                }
            }
        }
    }
}