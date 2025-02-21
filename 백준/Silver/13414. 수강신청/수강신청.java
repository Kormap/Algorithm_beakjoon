import java.io.*;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = Integer.parseInt(st.nextToken());         // 최대 수용인원
        int applyCount = Integer.parseInt(st.nextToken());  // 지원자 수
        
        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i< applyCount; i++) {
            String stdNum = br.readLine();
            set.remove(stdNum);
            set.add(stdNum);
        }

        int count = 0;
        for (String value : set) {
            if(count == max) break;
            System.out.println(value);
            count++;
        }
    }
}