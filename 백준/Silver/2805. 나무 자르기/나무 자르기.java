import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용해 입력을 받고 StringTokenizer로 나누기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int low = 0;
        int high = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if(high < tree[i])
                high = tree[i];
        }

        // 이진 탐색
        while(low < high) {
            int mid = (low + high) / 2;
            long sum = 0;
            for(int treeHeight : tree) {
                if(treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }

            if(sum < M) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }
}