import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int N = sc.nextInt();
        int answer = 0;

        for(int i = 0; i < N; i++) {
            String word = sc.next();
            char prevWord = ' ';
            boolean[] seenWord = new boolean[26];   //소문자 index 배열용도 사용
            boolean checker = false;
            
            //그룹단어인지 판단
            //알파벳이 연속되지 않고 나타나는 알파벳은 그룹단어가 아님
            for(int j = 0; j < word.length(); j++) {
                // 이전 알파벳과 다르다면 : 중복 검사, 같다면 : 중복 검사 X
                if(word.charAt(j) != prevWord){
                    //seenWord 에 기록되어있지 않은 알파벳인경우 seenWord 배열에 기록
                    if(!seenWord[word.charAt(j) - 'a']){
                        seenWord[word.charAt(j) - 'a'] = true;
                        checker = true;
                    }
                    else {  //기록되어있는 경우 그룹단어에서 배제
                        seenWord[word.charAt(j) - 'a'] = false;
                        checker = false;
                        break;
                    }
                }
                prevWord = word.charAt(j);
            }

            if(checker == true){
                answer++;
            }
        }

        System.out.println(answer);

    }
    

}