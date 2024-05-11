import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용해 입력을 받고 StringTokenizer로 나누기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lines = new int[K];

        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lines);

        long low = 1;
        long high = lines[K - 1];

        // 이진 탐색
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for (int line : lines) {
                sum += line / mid;
            }

            if (sum < N) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}