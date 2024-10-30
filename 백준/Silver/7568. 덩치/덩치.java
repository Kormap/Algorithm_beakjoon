import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();   //사람 수
        int[][] group = new int[N][2];

        for(int i = 0; i < N; i++) {
            int x = sc.nextInt(); //몸무게
            int y = sc.nextInt(); //키

            group[i][0] = x;    //몸무게
            group[i][1] = y;    //키
        }

        for(int i = 0; i < N; i++) {
            int grade = 1;

            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                
                if(group[i][0] < group[j][0] && group[i][1] < group[j][1]){
                    grade++;
                }
            }
            System.out.println(grade);

        }
    }
}