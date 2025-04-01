import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String detect = br.readLine();
        String anwer = br.readLine();
        
        // 숫자를 제거한 문자열 추출
        StringBuilder sb = new StringBuilder();
        for (char c : detect.toCharArray()) {
            if (!Character.isDigit(c)) {
                sb.append(c);
            }
        }

        System.out.println(KMP(sb.toString(), anwer) ? 1 : 0);
    }

    static boolean KMP(String text, String pattern) {
        // 실패 함수 역할
        int[] fail = new int[pattern.length()];
        for (int i = 1, j = 0; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = fail[j - 1];
            }
            
            if (pattern.charAt(i) == pattern.charAt(j)) {
                fail[i] = ++j;
            }
        }
        
        // 문자열 검색
        for (int i = 0, j = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = fail[j - 1];
            }
            
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    return true;
                } else {
                    j++;
                }
            }
        }
        
        return false;
    }
}
