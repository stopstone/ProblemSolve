import java.util.Stack

fun main() {

    // 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
    val N = readln().toInt()
    val stack = Stack<Int>()

    // 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.

    repeat(N) {
        /*
        * push X: 정수 X를 스택에 넣는 연산이다.
        * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        * size: 스택에 들어있는 정수의 개수를 출력한다.
        * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
        * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        * */
        val line = readln()
        val parts = line.split(' ') // 명령과 인자를 분리

        when (parts[0]) {
            "push" -> {
                val x = parts[1].toInt() // 두 번째 토큰을 정수로 변환
                stack.push(x)
            }
            "pop" -> {
                if (stack.isEmpty()) println(-1) else println(stack.pop())
            }
            "size" -> {
                println(stack.size)
            }
            "empty" -> {
                if (stack.isEmpty()) println(1) else println(0)
            }
            "top" -> {
                if (stack.isEmpty()) println(-1) else println(stack.last())
            }
        }

    }
}