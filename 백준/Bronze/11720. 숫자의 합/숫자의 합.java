import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int n;

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //숫자의 개수

        st = new StringTokenizer(br.readLine());
        String numbers = st.nextToken();

        int sum = 0;
        for (int i = 0; i < numbers.length(); i++){
            int number = numbers.charAt(i) - '0';
            sum += number;
        }

        System.out.println(sum);
    }
}