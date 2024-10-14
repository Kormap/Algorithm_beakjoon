import java.util.Scanner;

public class Main {
    static int[] fibo;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        fibo[0] = 0;
        fibo[1] = 1;

        System.out.println(fibonacci(n));

    }
    public static int fibonacci(int n) {
        if(n <= 1) return n;
        if(fibo[n] != 0) return fibo[n];
        
        fibo[n] = fibonacci(n-1) + fibonacci(n-2);
        return fibo[n];
    }
}