import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> commands = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            commands.add(command);
        }
        processDequeCommand(commands);
    }

    public static void processDequeCommand(List<String> commands) {
        StringBuilder sb = new StringBuilder();

        for (String command : commands) {
            String[] part = command.split(" ");
            String realCommand = part[0];
            int num = -1;

            if(command.contains("push")) {  // push 명령어만 정수를 받아 처리
                num = Integer.parseInt(part[1]);
            }

            switch (realCommand) {
                case "push_front":  // 덱의 앞에 push
                    deque.addFirst(num);
                    break;
                case "push_back":   // 덱의 뒤에 push
                    deque.offerLast(num);
                    break;
                case "pop_front":   // 덱의 맨앞 pop
                    if(!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "pop_back":    // 덱의 맨뒤 pop
                    if(!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(!deque.isEmpty()) sb.append("0").append("\n");
                    else sb.append("1").append("\n");
                    break;
                case "front":
                    if(!deque.isEmpty()) sb.append(deque.peekFirst()).append("\n");
                    else sb.append("-1").append("\n");
                    break;
                case "back":
                    if(!deque.isEmpty()) sb.append(deque.peekLast()).append("\n");
                    else sb.append("-1").append("\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}