import java.util.*

fun main() {
    // 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다.
    val (N, K) = readln().split(" ").map { it.toInt() }

    val results = mutableListOf<Int>()
    var queue = ArrayDeque<Int>().apply {
        for (i in 1..N) add(i)
    }


    // 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
    while (queue.isNotEmpty()) {
        // 지워야 하는 값을 맨 앞으로 보내기
        repeat(K - 1) {
            queue.add(queue.removeFirst())
        }

        // 지울 값 제거 후 results 리스트에 저장
        val remove = queue.remove()
        results.add(remove)
    }

    println("<${results.joinToString() }>")
}