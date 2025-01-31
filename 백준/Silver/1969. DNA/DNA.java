import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] map;       // 창고
    static int M;
    static int N;
    static int H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());   //DNA 수
        int M = Integer.parseInt(st.nextToken());   //DNA 길이
        String[] dnaString = new String[N];
        char[] dnaArr = new char[] {'A', 'C', 'G', 'T'};

        for (int i = 0; i < N; i++) {
            dnaString[i] = br.readLine();
        }

        int totalHammingDistance = 0;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < M; j++) {
            int minHammingDistance = Integer.MAX_VALUE;
            char minChar = 'A';     // hammingDistance 가 가장 작은문자

            for (char c : dnaArr) {
                int hammingDistance = 0;
                
                for (int i = 0; i < N; i++) {
                    // 각 DNA문자열의 문자 단건과 4가지 DNA 물질(A,T,G,C) 비교
                    if(dnaString[i].charAt(j) != c) {
                        // 문자가 다를경우 distance 증가
                        hammingDistance++;
                    }
                }
                if(hammingDistance < minHammingDistance) {
                    minHammingDistance = hammingDistance;
                    minChar = c;
                }
            }
            sb.append(minChar);
            totalHammingDistance += minHammingDistance;
        }
        System.out.println(sb.toString());
        System.out.println(totalHammingDistance);
    }
}