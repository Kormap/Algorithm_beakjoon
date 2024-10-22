import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int N = 0;
    static int part = 0;        //단지
    static int houseNum = 1;    //집번호(호수), 1번부터 시작)

    static int[][] map;
    static ArrayList<Integer> mapInfo = new ArrayList<>();;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
       N = sc.nextInt();
       map = new int[N][N];         // NxN 아파트

       visited = new boolean[N][N]; // 방문처리 배열

       for(int i = 0; i < N; i++){
            String nums = sc.next();
            for(int j = 0; j < nums.length(); j++){
                map[i][j] = nums.charAt(j) - '0';
            }
       }

       //깊이 우선 탐색
       for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    dfs(i, j);
                    part++; //단지 수
                    mapInfo.add(houseNum);
                    houseNum = 1;   //단지가 변경될때, 집 호수 초기화
                }
            }
       }
       
       //단지 수 출력
       System.out.println(part);

       //집의 수를 오름차순으로 정렬하기 위해 sorting
       Collections.sort(mapInfo);

       //집의 수 출력
       for(int i = 0; i < mapInfo.size(); i++){
            System.out.println(mapInfo.get(i));
       }


    }
    
    static public void dfs(int i, int j){
        visited[i][j] = true;

        //Step1. 지도 탐색하며 각 구역마다 단지, 집의 호 수 정보를 mapInfo 에 저장
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //상하좌우 4방향 탐색
        for(int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];

            //배열 내 지역만 탐색
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    houseNum++; //집 호수
                    dfs(nx, ny);
                }
            }
        }
    }
}