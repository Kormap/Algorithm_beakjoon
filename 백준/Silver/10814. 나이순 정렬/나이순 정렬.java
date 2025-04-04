import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[][] clients = new String[N][2];  // 나이, 이름 저장배열

        for (int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         String age = st.nextToken();
         String name = st.nextToken();

         clients[i][0] = age;
         clients[i][1] = name;
        }

        // 나이를 기준으로 오름차순 정렬
        Arrays.sort(clients, (a, b) -> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
        
        StringBuilder sb = new StringBuilder();
        for (String[] client : clients) {
            sb.append(client[0]).append(" ").append(client[1]).append("\n");
        }

        System.out.println(sb.toString());

    }
}
