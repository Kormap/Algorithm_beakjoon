import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        int yPrice = 0; // 영식
        int mPrice = 0; // 민식
        for (int time : times) {
            yPrice += (time / 30 + 1) * 10;
            mPrice += (time / 60 + 1) * 15;
        }

        if (yPrice > mPrice) {
            System.out.println("M " + mPrice);
        } else if (mPrice > yPrice) {
            System.out.println("Y " + yPrice);
        } else {
            System.out.println("Y M " + yPrice);
        }
    }
}
