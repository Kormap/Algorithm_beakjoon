import java.util.Scanner;


public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //갯수

        // 0~50 까지 인덱스 생성
        int counts[] = new int[51];

        // counts 배열 자리에 카운트
        for(int i=0; i < N; i++){
            counts[sc.nextInt()]++;
        }
        
        // 모순인 경우 -1
        int max = -1;

        for(int j=0; j < 51; j++){
            // 카운트가 잘됬는지 and 제일 큰 경우의 수인지 체크
            if(counts[j] == j && counts[j] > max){
                max = counts[j];
            }
        }

        System.out.println(max);
        sc.close();
      
    }
}
