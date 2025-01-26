import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int numCount;
    static ArrayList<String> numArr = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        
        while (numCount < n) {
            if (st.hasMoreTokens()) {
                numArr.add(st.nextToken());
                numCount++;
            } else {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                while(st2.hasMoreTokens() && numCount < n){
                    numArr.add(st2.nextToken());
                    numCount++;
                }
            }

        }

        for (int i = 0; i < numArr.size(); i++) {
            StringBuilder sb = new StringBuilder(numArr.get(i));
            String reverseNum = sb.reverse().toString();
            numArr.set(i, reverseNum);
        }

        // 10자리 이상의 수로, Long 타입으로 비교
        numArr.sort((a,b) -> Long.compare(Long.parseLong(a), Long.parseLong(b)));
        
        for (String val: numArr) {
            System.out.println(Long.parseLong(val)); 
        }
    }
}