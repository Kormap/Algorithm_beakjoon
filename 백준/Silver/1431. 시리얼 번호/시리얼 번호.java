import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String serialArr[] = new String[N];

        for (int i = 0; i < N; i++) {
            serialArr[i] = br.readLine();
        }

        Arrays.sort(serialArr, (s1, s2) -> {
            // 1. 길이순으로 오름차순 정렬
            if(s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            // 2. 각 자리가 숫자인 경우, 합산하여 오름차순 정렬
            int sumN1 = digitSum(s1);
            int sumN2 = digitSum(s2);
            if (sumN1 != sumN2) {
                return Integer.compare(sumN1, sumN2);
            }

            // 3. 사전순 오름차순 정렬
            return s1.compareTo(s2);
        });
    

        for (int i = 0; i < N; i++) {
            System.out.println(serialArr[i]);
        }
    }

    public static int digitSum(String serialNum){
        int sum = 0;
        for (int i = 0; i < serialNum.length(); i++) {
            if(Character.isDigit(serialNum.charAt(i))) {
                sum += Character.getNumericValue(serialNum.charAt(i));
            }
        }
        return sum;
    }
}