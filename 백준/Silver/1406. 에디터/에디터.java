import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine(); // 초기 문자열
        StringBuffer sb = new StringBuffer(word);

        int M = Integer.parseInt(br.readLine()); // 명령어 개수
        int idx = sb.length(); // 현재 커서 위치

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char command = st.nextToken().charAt(0);

            if (command == 'P') {
                String addStr = st.nextToken();
                sb.insert(idx, addStr);
                idx++;
            } else if (command == 'L') {
                if (idx != 0)
                    idx--;
            } else if (command == 'D') {
                if (idx != sb.length())
                    idx++;
            } else if (command == 'B') {
                if (idx != 0) {
                    sb.delete(idx - 1, idx);
                    idx--;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
