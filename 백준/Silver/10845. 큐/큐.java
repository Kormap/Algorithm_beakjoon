import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        commandProcess(N, br);
    }

    public static void commandProcess(int commandCount, BufferedReader br) throws Exception {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < commandCount; i++) {    
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    deque.offer(num);
                    break;
                case "pop":
                    System.out.println(deque.isEmpty() ? "-1" : deque.pop());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? "1" : "0");
                    break;
                case "front":
                    System.out.println(deque.isEmpty() ? "-1" : deque.peekFirst());
                    break;
                case "back":
                    System.out.println(deque.isEmpty() ? "-1" : deque.peekLast());
                    break;
            }
        }
    }
}
