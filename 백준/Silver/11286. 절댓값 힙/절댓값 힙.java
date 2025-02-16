import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 절대값이 같을 경우, 작은수를 기준으로 오름차순 정렬
                if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                
                // 절대값 기준 오름차순 정렬
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) {
                pq.offer(x);
            } else {
                // x = 0 인 경우
                if(pq.isEmpty()) sb.append(0 + "\n");
                else sb.append(pq.poll() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}