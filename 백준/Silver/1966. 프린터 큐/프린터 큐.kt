import java.util.LinkedList
import java.util.Queue

fun main() {
    val t = readln().toInt() // 테스트 케이스 개수

    repeat(t) {
        val (n, m) = readln().split(" ").map { it.toInt() }
        val priorities = readln().split(" ").map { it.toInt() }

        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>().apply {
            priorities.forEachIndexed { index, value ->
                add(Pair(value, index))
            }
        }

        var printCount = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            // 뒤에 현재보다 더 높은 중요도가 있는지 확인
            val hasHigher = queue.any { it.first > current.first }

            if (hasHigher) {
                // 더 높은 중요도가 있으면 뒤로 보내기
                queue.add(current)
            } else {
                // 출력
                printCount++

                // 지금 출력된 문서가 m번 문서인지 확인
                if (current.second == m) {
                    println(printCount)
                    break
                }
            }
        }
    }
}