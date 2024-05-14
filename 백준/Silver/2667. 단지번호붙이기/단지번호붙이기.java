import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {

    static boolean[][] map;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};
    static List<Integer> answer;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N + 10][N + 10];
        answer = new ArrayList<>();


        // 맵 초기화
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i + 1][j + 1] = str[j].equals("1");
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j]) {
                    count = 1;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i).toString());
            bw.newLine();
        }

        br.close();
        bw.close();
    }


    private static void dfs(int y, int x) { // 행렬을 나타내기 때문에 y, x로 인자를 넘겨준다.
        map[y][x] = false; // 지나온 집 체크
        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if (map[newY][newX]) {
                count++; // 단지 내 집 개수 체크
                dfs(newY, newX);
            }
        }
    }
}
