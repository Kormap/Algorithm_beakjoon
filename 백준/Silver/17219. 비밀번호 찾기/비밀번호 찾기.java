import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> passwordInfo = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String url = st.nextToken();
            String password = st.nextToken();
            passwordInfo.put(url, password);
        }
        
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String password = passwordInfo.get(url);
            System.out.println(password);
        }
    }
}