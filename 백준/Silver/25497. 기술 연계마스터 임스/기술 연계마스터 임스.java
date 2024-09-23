import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();       // 스킬사용횟수
        String skill = sc.next();   // 스킬순서
        int answer = 0;

        // L, S 스택생성
        Stack<Character> lStack = new Stack<>();
        Stack<Character> sStack = new Stack<>();

        for(int i=0; i<skill.length(); i++){
            char oneSkill = skill.charAt(i);

            // 사전스킬 L,S 일 경우 스택 누적
            if(oneSkill == 'L')
                lStack.push('L');
            else if(oneSkill == 'S')
                sStack.push('S');
                
            // 본스킬 R,K 일 경우
            else if(oneSkill =='R'){
                //사전스킬 사용여부 확인
                if(!lStack.isEmpty()) {
                    answer++;
                    lStack.pop();
                }else {
                    break;
                }
            }
            else if(oneSkill =='K'){
                //사전스킬 사용여부 확인
                if(!sStack.isEmpty()) {
                    answer++;
                    sStack.pop();
                }else {
                    break;
                }
            }

            // 스킬이 숫자일경우 스킬 사용
            else if('1'<= oneSkill && oneSkill <= '9')
                answer++;
            
        }
        
        System.out.println(answer);

        sc.close();
    }
}
