import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static int N;
    static int K;
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visited = new int[MAX + 1];
        Arrays.fill(visited, -1); // 방문하지 않은 위치를 -1로 초기화
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(visited[K]);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int q = queue.remove();
            if (q == K) return;

            if (q - 1 >= 0 && visited[q - 1] == -1) {
                visited[q - 1] = visited[q] + 1;
                queue.offer(q - 1);
            }
            if (q + 1 <= MAX && visited[q + 1] == -1) {
                visited[q + 1] = visited[q] + 1;
                queue.offer(q + 1);
            }
            if (q * 2 <= MAX && visited[q * 2] == -1) {
                visited[q * 2] = visited[q] + 1;
                queue.offer(q * 2);
            }
        }
    }
}

