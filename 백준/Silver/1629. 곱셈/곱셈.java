import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long answer = recurse(A, B, C);
        System.out.println(answer);
    }

    public static long recurse(long A, long B, long C) {
        if(B == 0) {
            return 1;
        }
        if(B == 1) {
            return A % C;
        }

        long half = recurse(A, B/2, C);
        half = (half * half) % C;

        if(B % 2 == 1) {
            half = (half * A) % C;
        }
        return half;
    }
}