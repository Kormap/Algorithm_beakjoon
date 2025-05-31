import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int room = Integer.parseInt(br.readLine());
        int[] digitCount = new int[10]; // 0-9 배열

        // 각 자리수의 숫자 개수를 세기
        for (char ch : String.valueOf(room).toCharArray()) {
            digitCount[ch - '0']++;
        }

        // 6, 9는 동일 취급
        if (digitCount[6] + digitCount[9] > 0) {
            int sixNineCount = digitCount[6] + digitCount[9];
            digitCount[6] = digitCount[9] = (sixNineCount + 1) / 2; // 올림 처리
        }

        // 가장 많이 사용된 숫자의 개수를 찾기
        int maxCount = 0;
        for (int count : digitCount) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.println(maxCount);
    }
}
