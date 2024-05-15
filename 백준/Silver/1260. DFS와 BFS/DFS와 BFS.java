import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int V;
    public static boolean[] visit;
    public static int[][] arr;
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visit, false); // bfs를 위해 visit 배열 초기화

        bfs(V);

    }

    public static void dfs(int num) {
        visit[num] = true;
        System.out.print(num + " ");
        for (int i = 1; i <= N; i++) {
            if (arr[num][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int num) {
        q.add(num);
        visit[num] = true;

        System.out.print(num);
        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[idx][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    System.out.print(" " + i);
                }
            }
        }
    }
}