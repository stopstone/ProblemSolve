import java.util.*

fun main() {
    val n = readln().toInt()
    val queue: Queue<Int> = LinkedList()
    val result = mutableListOf<Int>()

    for (i in 1..n) {
        queue.add(i)
    }

    while (queue.size > 1) {
        result.add(queue.poll())
        queue.add(queue.poll())
    }

    result.add(queue.poll())
    println(result.joinToString(" "))
}
