import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;
    static HashMap<Integer, Integer> hashMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());    // 큐에 쌓일 작업 수
            minHeap = new PriorityQueue<>();   // 내림차순 정렬 우선순위 큐
            maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬 우선순위 큐
            hashMap = new HashMap<>();  // 숫자, 카운트 저장
            
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();   // I : 큐 삽입, D : 큐 삭제
                int num = Integer.parseInt(st.nextToken());

                queueJob(command, num);
            }
            
            // HashMap에 존재하지 않는 값 Heap 에서 제거 (hashMap에서 작업한 삭제처리과정을 Heap에 적용)
            while (!maxHeap.isEmpty() && !hashMap.containsKey(maxHeap.peek())) {
                maxHeap.poll();
            }
            
            while (!minHeap.isEmpty() && !hashMap.containsKey(minHeap.peek())) {
                minHeap.poll();
            }
            
            if(maxHeap.isEmpty() && minHeap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(maxHeap.poll()).append(" ").append(minHeap.poll()).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    // 커맨드별 큐 동작
    public static void queueJob(String command, int num) {
        int count = hashMap.get(num) != null ? hashMap.get(num) : 0;
 
        if("I".equals(command)) {
            hashMap.put(num, count + 1);    // 삽입 시 등장횟수 증가
            minHeap.offer(num);
            maxHeap.offer(num);
        } else if("D".equals(command)) {
            if(num == 1 && !maxHeap.isEmpty()) {
                while(!maxHeap.isEmpty()) {
                    int value = maxHeap.poll();
                    if(hashMapCheck(value)) break;  // 존재하는 경우 삭제, 루프종료
                }
            } else if(num == -1 && !minHeap.isEmpty()) {
                while(!minHeap.isEmpty()) {
                    int value = minHeap.poll();
                    if(hashMapCheck(value)) break;  // 존재하는 경우 삭제, 루프종료
                }
            }
        }
    }

    // 꺼낸 값의 빈도 체크, 존재하는경우 빈도 -1
    public static boolean hashMapCheck(int value) {
        boolean returnValue = false;    // false : 미존재, true : 존재

        if(hashMap.containsKey(value)) {
            returnValue = true;
            hashMap.put(value, hashMap.get(value) - 1);
            if(hashMap.get(value) == 0) hashMap.remove(value);
        }

        return returnValue;
    }
}