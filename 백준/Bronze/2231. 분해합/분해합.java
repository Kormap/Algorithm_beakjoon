import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 자연수
        int answer = 0;
        
        for(int i=1; i<=N; i++){
            int M = 0;  // 각 자리수 합
            int tempI = i;

            //자리수의 숫자를 다 더하기
            while (tempI > 0) {
                // 분해합 구하기
                M += tempI%10;
                tempI = tempI/10;
            }
            
            if(i+M == N){
                answer = i;
                break;
            }else{
                answer = 0;
            }
        }

        System.out.println(answer);
        sc.close();
      
    }
}
