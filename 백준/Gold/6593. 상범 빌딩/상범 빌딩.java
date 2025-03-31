import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dz = {0, 0, 0, 0, 1, -1}; // 위, 아래 포함 6방향
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};

    static class Point {
        int z, x, y, time;

        Point(int z, int x, int y, int time) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static String escapeBuilding(int startZ, int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startZ, startX, startY, 0));
        visited[startZ][startX][startY] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (building[current.z][current.x][current.y] == 'E') {
                return "Escaped in " + current.time + " minute(s).";
            }

            for (int i = 0; i < 6; i++) {
                int nz = current.z + dz[i];
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (isValid(nz, nx, ny)) {
                    visited[nz][nx][ny] = true;
                    queue.offer(new Point(nz, nx, ny, current.time + 1));
                }
            }
        }
        return "Trapped!";
    }

    private static boolean isValid(int z, int x, int y) {
        return (z >= 0 && z < L && x >= 0 && x < R && y >= 0 && y < C &&
                !visited[z][x][y] && building[z][x][y] != '#');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break; // 종료 조건

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            int startZ = 0, startX = 0, startY = 0;

            for (int z = 0; z < L; z++) {
                for (int x = 0; x < R; x++) {
                    String line = br.readLine();
                    for (int y = 0; y < C; y++) {
                        building[z][x][y] = line.charAt(y);
                        if (building[z][x][y] == 'S') {
                            startZ = z;
                            startX = x;
                            startY = y;
                        }
                    }
                }
                br.readLine(); // 층 간 빈 줄 처리
            }

            sb.append(escapeBuilding(startZ, startX, startY)).append("\n");
        }
        System.out.print(sb);
    }
}
