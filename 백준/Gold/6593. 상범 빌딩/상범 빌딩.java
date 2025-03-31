import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 이동 방향
        int[] dz = {0, 0, 0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break; // 종료 조건

            char[][][] building = new char[L][R][C];
            boolean[][][] visited = new boolean[L][R][C];
            int startZ = 0, startX = 0, startY = 0;

            // 건물 정보 입력
            for (int z = 0; z < L; z++) {
                for (int x = 0; x < R; x++) {
                    String line = br.readLine();
                    for (int y = 0; y < C; y++) {
                        building[z][x][y] = line.charAt(y);
                        if (building[z][x][y] == 'S') { // 시작 지점 저장
                            startZ = z;
                            startX = x;
                            startY = y;
                        }
                    }
                }
                br.readLine(); // 층 간 빈 줄 처리
            }

            // BFS 탐색을 위한 큐 (z, x, y, 시간)
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startZ, startX, startY, 0});
            visited[startZ][startX][startY] = true;
            boolean escaped = false;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int z = cur[0], x = cur[1], y = cur[2], time = cur[3];
                
                if (building[z][x][y] == 'E') { // 출구 발견 시 종료
                    sb.append("Escaped in ").append(time).append(" minute(s).\n");
                    escaped = true;
                    break;
                }

                // 6방향 탐색
                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i], nx = x + dx[i], ny = y + dy[i];
                    // 범위 체크 및 이동 가능 여부 확인
                    if (nz >= 0 && nz < L && nx >= 0 && nx < R && ny >= 0 && ny < C && 
                        !visited[nz][nx][ny] && building[nz][nx][ny] != '#') {
                        visited[nz][nx][ny] = true;
                        queue.offer(new int[]{nz, nx, ny, time + 1});
                    }
                }
            }

            if (!escaped) sb.append("Trapped!\n"); // 탈출 실패 시
        }
        System.out.print(sb); // 결과 출력
    }
}
