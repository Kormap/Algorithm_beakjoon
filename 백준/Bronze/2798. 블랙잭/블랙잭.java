import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   //카드 개수
        int M = sc.nextInt();   //숫자
        int diff = -1;

        int answer = 0;
        //카드의 수
        int[] cardNum = new int[N];
        for(int i=0; i<N; i++){
            cardNum[i] = sc.nextInt();
        }
        // 숫자 순차 정렬
//        cardNum =  Arrays.stream(cardNum).sorted().toArray();

        // 0 1 2, 500,501,502
        for(int x=0; x<cardNum.length-2; x++){
            for(int y=x+1; y<cardNum.length-1; y++){
                for(int z=y+1; z<cardNum.length; z++){
                    int sum = 0;
                    sum = cardNum[x] + cardNum[y] + cardNum[z];

                    //M 값에 가까운지 판별, M 보다는 작거나 같아야함
                    if(M >= sum){
                        if(diff > Math.abs(M-sum) || diff == -1){
                            diff = Math.abs(M-sum);
                            answer = sum;
                        }
                        if (Math.abs(M-sum) == 0) {
                            answer = sum;
                            break;

                        }
                    }

                }
            }
        }

        System.out.println(answer);
        sc.close();

    }
}
