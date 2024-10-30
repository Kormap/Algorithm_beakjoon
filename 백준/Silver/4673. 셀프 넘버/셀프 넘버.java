import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean[] selfNumArr = new boolean[10001];

    public static void main(String[] args) throws Exception {
        for(int i = 1; i <= 10000; i++) {
            selfNum(i);
        }
        
        // selfNumArr배열의 false 상태인 숫자들이 셀프넘버이다.
        for(int i = 1; i <= 10000; i++) {
            if(selfNumArr[i] == false){
                System.out.println(i);
            }
        }
        
    }

    public static void selfNum(int num){
        //Step1. num + 각 자리수의 합 찾기
        int sum = num;

        while(num > 0) {
            //num 의 자리수 찾기
            sum = sum + (num % 10);
            num /= 10;
        }

        //Step2. 생성자가 있는 숫자는 true 로 변경
        if(sum <= 10000) selfNumArr[sum] = true;
    }
}