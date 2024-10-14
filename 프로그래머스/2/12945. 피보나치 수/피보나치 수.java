class Solution {
    static int[] fiboArr;
    public int solution(int n) {
        int answer = 0;
        fiboArr = new int[n+1];
        fiboArr[0] = 0;
        fiboArr[1] = 1;
   
        answer = fibo(n)%1234567;
        return answer;
    }
    
    public int fibo(int N){
        if(N < 1) return 0;
        
        if(fiboArr[N] != 0) return fiboArr[N];
        
        fiboArr[N] = fibo(N-1)%1234567 + fibo(N-2)%1234567;
        
        return fiboArr[N];
    }
}