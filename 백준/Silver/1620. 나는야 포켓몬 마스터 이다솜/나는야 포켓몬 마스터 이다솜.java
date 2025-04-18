import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> nameMap = new HashMap<>();
        Map<String, Integer> numberMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameMap.put(i, name);       // 이름 기준 Map타입
            numberMap.put(name, i);     // 인덱스 기준 Map타입
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            //숫자 입력 시 포켓몬 이름 출력
            if(Character.isDigit(input.charAt(0))) {
                int num = Integer.parseInt(input);
                sb.append(nameMap.get(num) + "\n");
            } else {
                sb.append(numberMap.get(input) + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}