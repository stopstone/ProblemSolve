import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int maxSum;

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true; // 'ㅗ'를 제외한 블록은 DFS로 탐색
                dfs(i, j, 1, map[i][j]);
                maxSum = Math.max(getLast(i, j), maxSum);
                visited[i][j] = false;
            }
        }
        System.out.println(maxSum);

    }

    static void dfs(int row, int col, int cnt, int sum) {
        if (cnt == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < dirs.length; i++) {
            int newY = row + dirs[i][0];
            int newX = col + dirs[i][1];

            if (isRange(newY, newX) && !visited[newY][newX]) {
                visited[newY][newX] = true;
                dfs(newY, newX, cnt + 1, sum + map[newY][newX]);
                visited[newY][newX] = false;
            }
        }
    }

    static int getLast(int y, int x) {
        int base = map[y][x];
        int count = 0;// 사방 탐색 성공 회수
        int min = Integer.MAX_VALUE;
        
        // 중심점을 중심으로 사방 탐색
        for (int[] dir : dirs) {
            int newY = y + dir[0];
            int newX = x + dir[1];
            if (isRange(newY, newX) && x < M) {
                count++;
                base += map[newY][newX];
                min = Math.min(min, map[newY][newX]);
            }
        }
        // 4방 탐색이 4군데 다 성공했다면 최소값을 빼주기 - 이게 그나마 최대값
        if (count == 4) {
            return base - min;
        }
        // 3 방향만 성공했으면 그대로 진행
        else if (count == 3) {
            return base;
        }
        // 나머지경우는 모양 만들기 실패
        else {
            return -1;
        }
    }

    private static boolean isRange(int nr, int nc) {
        return 0 <= nr && nr < N && 0 <= nc && nc < M;
    }

}