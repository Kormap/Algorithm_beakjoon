import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String[] croatiaAlpha = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String word = sc.next();
        int answer = 0;

        for (int i = 0; i < word.length(); i++){
            char alpha = word.charAt(i);
            
            if(i < word.length()-1){
                if(alpha == 'c'){
                    char check = word.charAt(i+1);
                    if(check == '=' || check == '-'){
                        i++;
                    }
                }
    
                else if(alpha == 'd'){
                    char check = word.charAt(i+1);
                    if(check == '-'){
                        i++;
                    }
                    //d 가 세번째 자리 전에 위치하였을때만 dz= 체크
                    else if(i < word.length()-2){
                        char nextCheck = word.charAt(i+2);
                        if(check == 'z' && nextCheck == '='){
                            i = i + 2;
                        }
                    }
                }
    
                else if(alpha == 'l' || alpha == 'n'){
                    char check = word.charAt(i+1);
                    if(check == 'j'){
                        i++;
                    }
                }
    
                else if(alpha == 's' || alpha == 'z'){
                    char check = word.charAt(i+1);
                    if(check == '='){
                        i++;
                    }
                }
            }
           
            answer++;
        }
        System.out.println(answer);
    }
}