import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws Exception {

        StringBuilder sb = new StringBuilder();

        int fixPower = 3; // 3의 제곱근

        // 반복문
        for(int a=2; a<=100; a++){

            for(int b=2; b<=a; b++){
                for(int c=b; c<=a; c++){
                    for(int d=c; d<=a; d++){
                        // b,c,d 3의 제곱근 합산값
                        int sum = (int) (Math.pow(b, fixPower) + Math.pow(c, fixPower) + Math.pow(d, fixPower));

                        if(Math.pow(a, fixPower) == sum)
                        sb.append("Cube = "+ a + ", Triple = (" + b + "," + c + "," + d + ") \n");
                    }
                }
            }

        }

        System.out.println(sb);

    }
}
