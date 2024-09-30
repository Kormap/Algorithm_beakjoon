import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int tempAnswer = 0;
        int answer = Integer.MAX_VALUE;

        String[][] chessPlate = new String[N][M];

        // 체스판 생성
        for(int i = 0; i < N; i++) {
            String str = sc.next();

            for (int j = 0; j < M; j++) {
                chessPlate[i][j] = String.valueOf(str.charAt(j));
            }
        }

        // 8*8 크기로 체스판 완전탐색
        for(int i = 0; i < N-7; i++) {
            for (int j = 0; j < M-7; j++) {
                tempAnswer = chessSearch(chessPlate, i, j);
                // 변경이 최소인 경우가 정답
                if(tempAnswer < answer){
                    answer = tempAnswer;
                }
            }
        }

        System.out.println(answer);
    }

    public static int chessSearch(String[][] chessPlate, int x, int y){
        String startColor = chessPlate[x][y];   // 첫번째 색상
        int count = 0;

        for(int i = x; i < x+8; i++){
            for(int j = y; j < y+8; j++){
                // 다음 색이 이전 색과 같은 경우 -> 변경필요
                // 다음 색이 이전 색과 다른 경우 -> 넘어감
                if(!chessPlate[i][j].equals(startColor)){
                    count++;
                }
                // 다음에 위치해야하는 색상 설정
                startColor = changeColor(startColor);
            }

            // 줄 변경 시 색상 반전
            startColor = changeColor(startColor);
        }

        //첫번째 색이 W/B 에 따른 최소비용값 계산식
        return Math.min(count, 64 - count);
    }

    public static String changeColor(String color){
        if(color.equals("B")){
            color = "W";
        }else {
            color = "B";
        }
        return color;
    }
}
