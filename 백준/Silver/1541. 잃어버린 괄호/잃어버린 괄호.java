import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] minusPart = input.split("-");  // 마이너스를 기준으로
        
        int result = 0;
        int i = 0;

        for (String val : minusPart) {
            // System.out.println(val);
            String[] addPart = val.split("\\+");  // 플러스를 기준으로
            int sum = 0;

            for (String val2 : addPart) {
                // System.out.println(val2);
                sum += Integer.parseInt(val2);
            }
            // 첫번째 입력값은 항상 양수
            if(i == 0) result += sum;
            else result -= sum;
            i++;
        }
        System.out.println(result);
    }
}