import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
        K = Integer.parseInt(st.nextToken(" "));


        while ((N + M) - K >= 3 && N >= 2 && M >= 1) {
            answer++;
            N -= 2;
            M--;
        }
        System.out.println(answer);
    }
}

