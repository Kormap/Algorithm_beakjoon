import java.io.*;

public class Main {
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();
        String pattern = br.readLine();

        boolean result = kmp(text, pattern);
        System.out.println(result == true ? 1 : 0);
    }

    // 부분일치테이블(LPS 배열)
    public static int[] setLpsArray(String pattern) {
        int len = pattern.length();
        int[] lps = new int[len];

        int lpsValue = 0;   // 접두사, 접미사 일치 길이
        int i = 1;

        while (i < len) {
            // pattern.charAt(i) : 접미사
            // pattern.charAt(lpsValue) : 접두사
            if (pattern.charAt(i) == pattern.charAt(lpsValue)) {
                lpsValue++;
                lps[i] = lpsValue;
                i++;
            } else {
                if(lpsValue != 0) {
                    // 패턴이 일치하지 않는 경우 이전 접두사로 이동
                    lpsValue = lps[lpsValue - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static boolean kmp(String text, String pattern) {
        int tl = text.length();
        int pl = pattern.length();
        int[] lps = setLpsArray(pattern);

        int i = 0; // text 인덱스
        int j = 0; // pattern 인덱스

        while (i < tl) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            // 패턴이 본문 문자열 부분에 일치하는 경우
            if (j == pl) {
                return true;
            } else if (i < tl && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j-1];   // LPS 배열을 이용
                } else {
                    i++; // text 문자열의 다음 인덱스로 이동
                }
            }
        }
        return false;
    }

}