import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Map<String, String> hashMap = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String inout = st.nextToken();  // enter, leave
            if("enter".equals(inout)) hashMap.put(name, inout);
            else hashMap.remove(name);
        }

        for (String name : hashMap.keySet()) {
            System.out.println(name);
        }
    }
}
