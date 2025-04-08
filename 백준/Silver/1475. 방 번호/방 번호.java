import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String roomNumber = br.readLine();

        // 숫자저장 배열 (0~9)
        int[] digitCounts = new int[10];

        // 각 숫자의 등장 횟수 계산
        for (char digit : roomNumber.toCharArray()) {
            digitCounts[digit - '0']++;
        }

        // 6과 9는 뒤집어서 사용 가능
        int sixNineCount = digitCounts[6] + digitCounts[9];
        digitCounts[6] = (sixNineCount + 1) / 2;
        digitCounts[9] = 0;

        int maxSetCount = 0;
        for (int count : digitCounts) {
            maxSetCount = Math.max(maxSetCount, count);
        }

        // 결과 출력
        System.out.println(maxSetCount);
    }
}
