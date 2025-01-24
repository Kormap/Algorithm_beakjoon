import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputStrings = new String[N];
        ArrayList<String> numbers = new ArrayList<>();

        for (int i = 0; i < inputStrings.length; i++) {
            inputStrings[i] = br.readLine();
        }
        
        for (String val : inputStrings) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < val.length(); i++) {
                char c = val.charAt(i);
                if(Character.isDigit(c)){
                    sb.append(c);
                } else {
                    if(sb.length() > 0){
                        numbers.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            }
            if(sb.length() > 0) {
                numbers.add(sb.toString());
            }
        }

        numbers.sort((a, b) -> {
            // 01, 001 등의 숫자를 1로 나타내기 위해 변환
            a = new BigInteger(a).toString();
            b = new BigInteger(b).toString();

            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        for(String val : numbers) {
            System.out.println(new BigInteger(val).toString());
        }
    }
}