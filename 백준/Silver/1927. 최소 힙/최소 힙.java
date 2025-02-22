import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 기본적으로 오름차순 정렬됨
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(!pq.isEmpty() && x == 0) {
                sb.append(pq.poll()).append("\n");
            } else if(x != 0) {
                pq.offer(x);
            } else if(pq.isEmpty()) {
                sb.append("0" + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}