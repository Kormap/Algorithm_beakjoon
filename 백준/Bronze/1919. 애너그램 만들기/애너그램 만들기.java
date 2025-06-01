import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String aWord = br.readLine();
        String bWord = br.readLine();

        int[] alphaCount = new int[26]; // 알파벳 출현 개수
        for (char ch : aWord.toCharArray()) {
            alphaCount[ch - 'a']++;
        }

        for (char ch : bWord.toCharArray()) {
            alphaCount[ch - 'a']--;
        }

        int answer = 0;
        for (int count : alphaCount) {
            if (count != 0)
                answer += Math.abs(count);
        }

        System.out.println(answer);
    }
}
