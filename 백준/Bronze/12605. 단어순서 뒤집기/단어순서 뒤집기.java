import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String[] caseArr = new String[N];
        String[] answerArr = new String[N];

        sc.nextLine();

        for(int i=0; i<N; i++){
            caseArr[i] = sc.nextLine();
        }

        // 각 행의 String 타입
        for(int j=0; j<caseArr.length; j++){
            String[] splitStr = caseArr[j].split(" "); // Split : test / is / ok
            String splitWord = new String();

            // 각 행의 단어 개수만큼 반복
            for(int k=splitStr.length-1; k>=0; k--){
                splitWord += splitStr[k] + " ";
                
            }
            System.out.println("Case #" +(j+1) + ": "+ splitWord.trim());
        }

        sc.close();
    }
}
