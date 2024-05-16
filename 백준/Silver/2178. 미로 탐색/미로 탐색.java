import java.io.*;
import java.util.*;

public class Main {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        maze = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(s.substring(j,j+1));
            }
        }


        bfs(0,0);
        System.out.println(maze[N-1][M-1]);
    }

    public static void bfs(int start_x, int start_y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start_x][start_y] = true;
        queue.add(new int[] {start_x,start_y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll(); //현재 위치
            int x = now[0];
            int y = now[1];

            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX>=0 && nextY>=0 && nextX<N && nextY<M) {
                    if(maze[nextX][nextY]==1 && !visited[nextX][nextY]) {
                        queue.add(new int[] {nextX, nextY});
                        visited[nextX][nextY]=true;
                        maze[nextX][nextY] = maze[x][y]+1;
                    }
                }
            }
        }
    }
}