fun main() {
    val queue = ArrayDeque<Int>().apply {
        repeat(readln().toInt()) {
            add(it + 1)
        }
    }

    while (queue.size > 1) {
        queue.removeFirst() // 큐의 첫번째 값은 날린다.

        if (queue.isNotEmpty()) { // 큐가 존재할 경우
            val top = queue.removeFirst() // 맨 앞의 값을 뒤로 옮긴다.
            queue.addLast(top)
        }
    }
    println(queue.first())
}