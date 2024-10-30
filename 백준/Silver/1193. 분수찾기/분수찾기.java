import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        /* 
         *  1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> ...
         *  0,0, 0,1 1,0 0,2 1,1
         *  2번째 : 1번째 y+1
         *  3번째 : 2번째 x+1, y-1
         *  4번째 : 3번째 x+1
         *  5번째 : 4번째 x-1, y+1
         */

         int x = sc.nextInt();
         
         int line = 1;  //현재 대각선에 포함된 숫자 개수
         int sum = 0;   //총 포함된 숫자 개수

         while (sum + line < x) {
            sum += line;
            line++; //n번째 대각선에는 n개의 숫자가 있음
         }

         int pos = x - sum; //대각선 내 위치 계산
         int top, down;     //분자/분모

         // line : x가 몇번째 대각선인지 나타냄
         // sum : x번째 대각선에 총 포함된 숫자 개수
         if(line % 2 == 0) {    //짝수 대각선
            top = pos;
            down = line - pos + 1;
         } else {   //홀수 대각선
            top = line - pos + 1;
            down = pos;
         }

         System.out.println(top + "/" + down);
    }
}