import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    static int answer;
    static int prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            answer += prev + arr[i];
            prev += arr[i];
        }
        System.out.print(answer);
    }
}

