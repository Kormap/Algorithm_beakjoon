import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        sc.close();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        sb.append("<");
        while (q.size() != 1) {
            for(int i = 1; i <= K-1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll() + ", ");
        }
        q.offer(q.poll());
        sb.append(q.poll() + ">");

        System.out.println(sb);
    }
}