import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Stack {
    private final int[] stack;
    private int top;

    // 생성자
    public Stack(int N) {
        stack = new int[N];
        top = 0;
    }

    public void push(int x) {
        stack[top++] = x;
    }

    public int pop() {
        return top < 1 ? -1 : stack[--top];
    }

    public int size() {
        return top;
    }

    public int isEmpty() {
        return top == 0 ? 1 : 0;
    }

    public int top() {
        return top < 1 ? -1 : stack[top - 1];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack(N);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }
        }
        br.close();
    }
}