import java.util.*
fun main() {
    val test = readln().toInt()

    repeat(test) {
        val stack = Stack<Int>()

        for (ps in readln()) {
            when(ps) {
                '(' -> stack.push(1)
                ')' -> {
                    if (stack.isEmpty()) {
                        stack.push(1)
                        break
                    } else {
                        stack.pop()
                    }
                }
            }
        }

        val result = when(stack.isEmpty()) {
            true -> "YES"
            false -> "NO"
        }
        println(result)
    }
}