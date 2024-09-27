import java.util.Scanner;


public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //갯수
        int counts[] = new int[51];
        
        int answer = 0;

        for(int i=0; i < N; i++){
            counts[sc.nextInt()]++;
        }
        
        int max = -1;
        for(int j=0; j < 51; j++){
            if(counts[j] > max && counts[j] == j){
                max = counts[j];
            }
        }

        System.out.println(max);
        sc.close();
      
    }
}
