import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> times = new ArrayList<>();
        

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            times.add(new int[] {start, end});
        }
        
        // 회의 종료시간이 빠른순서로 정렬
        times.sort((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);    // 종료시간이 같은 경우 시작시간이 빠른순서 정렬
        });
        
       int lastTime = 0;
       int count = 0;

        for (int[] timeArr : times) {
            int startTime = timeArr[0];
            int endTime = timeArr[1];

            // 이전회의와 시간이 겹치는지 확인
            if(startTime >= lastTime) {
                lastTime = endTime;
                count++;
            }
        }

        System.out.println(count);
    }
}