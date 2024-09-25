import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트케이스
        int[] countArr = new int[T];
        
        
        for(int i=0; i<T; i++){
            int answer = 0;
            int n = sc.nextInt();
            int m = sc.nextInt();

            for(int b=0; b<n; b++){
                for(int a=0; a<b; a++){
                   double dNum = (Math.pow(a, 2) + Math.pow(b, 2) + m) / (a*b);
                   if(isInteger(dNum)){
                    answer++;
                   }
                }
            }

            countArr[i] = answer;
        }

        sc.close();
        for(int i=0; i<countArr.length; i++)
        System.out.println(countArr[i]);
    }

    // 실수->정수 판별 메소드
    public static boolean isInteger(double num){
        return num % 1 == 0.0;
    }
}
