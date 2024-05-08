import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    String[] stack;

    public void solution(String words) {
        stack = words.split(" ");

        for (String s : stack) {
            String temp = new StringBuilder(s).reverse().toString();
            System.out.print(temp + " ");
        }
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        Solution solution = new Solution();
        for (int i = 0; i < T; i++) {
            solution.solution(br.readLine());
        }
    }
}