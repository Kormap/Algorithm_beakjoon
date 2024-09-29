import java.util.Scanner;


public class Main {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true){
            String targetAlpha = sc.next().toLowerCase();
            String words = sc.nextLine().toLowerCase().trim();
            int answer = 0;

            if(targetAlpha.equals("#")){
                break;
            }

            for(int i=0; i<words.length(); i++){
                if(targetAlpha.equals(Character.toString(words.charAt(i)))){
                    answer++;
                }
            }

            System.out.println(targetAlpha +" " +answer);
        }

        sc.close();

    }
}
