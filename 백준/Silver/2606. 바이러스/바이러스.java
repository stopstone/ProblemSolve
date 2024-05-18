import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static boolean[][] graph;
    static int N, M;
    static int answer;

    public static void main(String[] args) throws IOException {
        // 초기화 단계
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // graph에 연결정보 세팅
        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        dfs(1);
        bw.write(String.valueOf(answer - 1));

        br.close();
        bw.close();
    }

    private static void dfs(int idx) {
        visited[idx] = true; // 방문완료
        answer++;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[idx][i])
                dfs(i);
        }
    }

}
