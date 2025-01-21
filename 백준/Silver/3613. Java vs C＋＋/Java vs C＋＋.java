import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();
        if (!isValid(word)) {
            System.out.println("Error!");
            return;
        }


        String convertedWord = convertLanguage(word);
        System.out.println(convertedWord);
    }

    public static String convertLanguage(String word) {
        StringBuilder sb = new StringBuilder();
        int wordLength = word.length();
        
        // C++ -> JAVA 형식 변수명
        if (word.contains("_")) {
            for (int i = 0; i < wordLength; i++) {
                char nowChar = word.charAt(i);
                if(nowChar == '_') {
                    boolean hasNextChar = i + 1 < wordLength;
                    if (hasNextChar) {
                        char underscoreNextChar = word.charAt(i+1);
                        sb.append(Character.toUpperCase(underscoreNextChar));
                        i++;
                    }
                } else {
                    sb.append(nowChar);
                }
            }
        } else {
            // JAVA -> C++ 형식 변수명
            for (int i = 0; i < wordLength; i++) {
                char nowChar = word.charAt(i);
                boolean isUpper = Character.isUpperCase(nowChar);
                
                if (isUpper) {
                    sb.append('_').append(Character.toLowerCase(nowChar));
                } else {
                    sb.append(nowChar);
                }
            }
        }
        return sb.toString();
    }

    public static boolean isValid(String word) {
        // 시작 또는 끝에 '_'가 있으면 안 됨
        if (word.startsWith("_") || word.endsWith("_")) {
            return false;
        }
        // 두 개 이상의 '_'가 연속으로 나오면 안 됨
        if (word.contains("__")) {
            return false;
        }
        // 첫글자는 대문자이면 안 됨
        if (Character.isUpperCase(word.charAt(0))){
            return false;
        }
        // 대문자와 '_'가 혼합되면 안 됨
        boolean hasUpper = false, hasUnderscore = false;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (c == '_') {
                hasUnderscore = true;
            }
        }
        
        return !(hasUpper && hasUnderscore);
    }
}