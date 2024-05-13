import java.io.*;
import java.util.StringTokenizer;

class Main {

    static final int MAX = 50 + 10; // 최대 M,N값 50에서 여유분의 사이즈를 지정한다.
    static boolean[][] map;
    static boolean[][] visit;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};
    static int T, M, N, K;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX]; // 양배추 농사를 지을 영역을 지정한다.
            visit = new boolean[MAX][MAX]; // 방문한 지역을 표시한다.

            // map에 양배추가 있는 위치 그리기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y + 1][x + 1] = true; // 1부터 심어질 수 있도록 + 1
            }


            // dfs 실행
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] && visit[i][j] == false) { // 양배추가 있고, 방문하지 않았을 경우
                        answer++; // 지렁이 추가
                        dfs(i, j);
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }


        br.close();
        bw.close();
    }

    private static void dfs(int y, int x) { // 행렬을 나타내기 때문에 y, x로 인자를 넘겨준다.
        visit[y][x] = true; // 방문했음
        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if (map[newY][newX] && visit[newY][newX] == false) {
                dfs(newY, newX);
            }
        }
    }
}