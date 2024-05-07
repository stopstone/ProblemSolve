import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        String result = solution.solution();
        System.out.println(result);
    }
}

class Solution {
    private BufferedReader br;
    private StringBuilder sb;
    private StringTokenizer st;
    private ArrayList<Integer> queue;

    public String solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        queue = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int i = 0;
        sb.append('<');
        while (!queue.isEmpty()) {
            i = (i + (K - 1)) % queue.size();
            sb.append(queue.remove(i));
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append('>');

        return sb.toString();
    }
}